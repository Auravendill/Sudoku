import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;


public class CreateP {


    public static void createPdf(String dest, ArrayList<Sudoku> sudo) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(9);

        float fntSize, lineSpacing;
        fntSize = 11f;
        lineSpacing = 10f;


        //EmptyTable zum erzeugen einer Leerzeile
        PdfPTable emptytable = new PdfPTable(1);
        PdfPCell cellemp = new PdfPCell(new Phrase("\n"));
        cellemp.setBorderColor(BaseColor.WHITE);
        emptytable.addCell(cellemp);


        for(int k=0;k<sudo.size();k++)
        {
        	PdfPTable nexttable = new PdfPTable(9);

        	for(int i=0;i<9;i++)
        	{
        		for(int j=0;j<9;j++)
        		{
        			String var= "";
        			if(sudo.get(k).getAt(i,j)==0)
        			{
        				var=" ";
        			}
        			else
        			{
        				var=var + sudo.get(k).getAt(i,j);
        			}
        			PdfPCell cellTwo = new PdfPCell(new Phrase(lineSpacing,var,
                    FontFactory.getFont(FontFactory.COURIER, fntSize)));

        			cellTwo.setHorizontalAlignment(Element.ALIGN_CENTER);
        			cellTwo.setPadding(15.0f);
        			if(i==0)
        			{
        				cellTwo.setBorderWidthTop(5);
        			}
        			if(j==0)
        			{
        				cellTwo.setBorderWidthLeft(5);
        			}
        			if((i+1)%3==0)
        			{
        				cellTwo.setBorderWidthBottom(5);
        			}
        			if((j+1)%3==0)
        			{
        				cellTwo.setBorderWidthRight(5);
        			}

        			nexttable.addCell(cellTwo);
        		}
        	}
        	document.add(nexttable);
        	document.add(emptytable);
        }

        document.close();
    }

}
