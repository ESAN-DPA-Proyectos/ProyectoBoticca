/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;

import BEAN.Categoria;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberth
 */
public class PdfGenerator {

     public static ByteArrayOutputStream generarPDFDinamico(List<Object> objetos, String archivoSalida) {
        Document documento = new Document();
        
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        try {
            PdfWriter writer = PdfWriter.getInstance(documento, outputStream);
            documento.open();

            // Fuentes
            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font fontEncabezado = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
            Font fontDatos = new Font(Font.FontFamily.HELVETICA, 10);

            // Título
            Paragraph titulo = new Paragraph(archivoSalida, fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            documento.add(titulo);

            if (objetos.isEmpty()) {
                documento.add(new Paragraph("No hay datos disponibles", fontDatos));
                return outputStream;
            }

            // Obtener campos del primer objeto
            Object primerObjeto = objetos.get(0);
            Field[] campos = primerObjeto.getClass().getDeclaredFields();

            // Crear tabla
            PdfPTable tabla = new PdfPTable(campos.length);
            tabla.setWidthPercentage(100);
            tabla.setSpacingBefore(10);
            tabla.setSpacingAfter(20);

            // Color de encabezado
            BaseColor colorEncabezado = new BaseColor(70, 130, 180); // Azul acero

            // Agregar encabezados
            for (Field campo : campos) {
                PdfPCell celda = new PdfPCell(new Phrase(formatearNombreCampo(campo.getName()), fontEncabezado));
                celda.setBackgroundColor(colorEncabezado);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setPadding(5);
                tabla.addCell(celda);
            }

            // Agregar datos
            BaseColor colorFilaPar = new BaseColor(240, 240, 240);
            int contador = 0;

            for (Object objeto : objetos) {
                for (Field campo : campos) {
                    campo.setAccessible(true);
                    try {
                        Object valor = campo.get(objeto);
                        PdfPCell celda = new PdfPCell(new Phrase(formatearValor(valor), fontDatos));
                        celda.setPadding(5);

                        // Alternar colores de fila
                        if (contador % 2 == 0) {
                            celda.setBackgroundColor(colorFilaPar);
                        }

                        // Alineación según tipo de dato
                        if (valor instanceof Number) {
                            celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        } else {
                            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
                        }

                        tabla.addCell(celda);
                    } catch (IllegalAccessException e) {
                        tabla.addCell(new PdfPCell(new Phrase("Error", fontDatos)));
                    }
                }
                contador++;
            }

            documento.add(tabla);
            documento.close();
            writer.close();

            return outputStream;

        } catch (Exception e) {
            System.err.println("Error al generar PDF: " + e.getMessage());
        } finally {
            if (documento != null && documento.isOpen()) {
                documento.close();
            }
        }
        return null;
     }
     
     private static String formatearNombreCampo(String nombre) {
        // Convertir camelCase a texto normal: "precioUnitario" -> "Precio Unitario"
        return nombre.substring(0, 1).toUpperCase() + 
               nombre.substring(1).replaceAll("([A-Z])", " $1");
    }

    private static String formatearValor(Object valor) {
        if (valor == null) return "";
        
        if (valor instanceof Double || valor instanceof Float) {
            return String.format("%,.2f", valor);
        }
        
        if (valor instanceof Boolean) {
            return (Boolean) valor ? "Sí" : "No";
        }
        
        return valor.toString();
    }
}
