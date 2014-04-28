import com.itextpdf.text.*;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.codec.TiffImage;

import java.io.FileOutputStream;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, DocumentException {
		RandomAccessSourceFactory factory = new RandomAccessSourceFactory();
		String img1 = "resources/56.tiff";
		RandomAccessFileOrArray ra = new RandomAccessFileOrArray(factory.createBestSource(img1));

		Image image = TiffImage.getTiffImage(ra, 1);
		System.out.println("Width: " + image.getWidth());
		System.out.println("Height: " + image.getHeight());
		Rectangle pageSize = new Rectangle(image.getWidth(), image.getHeight());

		Document document = new Document(pageSize);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("resources/out.pdf"));

		writer.setStrictImageSequence(true);
		document.open();
		document.add(image);



		document.newPage();

		document.close();
	}
}
