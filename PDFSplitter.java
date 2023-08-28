import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class PDFSplitter {
    public static void main(String[] args) {
        String sourceFilePath = "C:\\Users\\ankit\\Desktop\\Rahul's Resume.pdf";
        String outputDir = "C:\\Users\\ankit\\Desktop\\New folder (2)";

        try {


            PDDocument document = Loader.loadPDF(new File(sourceFilePath));
            Splitter splitter = new Splitter();
            List<PDDocument> pages = splitter.split(document);

            int pageNumber = 1;
            for (PDDocument page : pages) {
                String outputPath = outputDir + "\\page_" + pageNumber + ".pdf";
                page.save(outputPath);
                page.close();
                pageNumber++;
            }

            document.close();
            System.out.println("PDF splitting complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
