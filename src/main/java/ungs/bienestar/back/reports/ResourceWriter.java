package ungs.bienestar.back.reports;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;

@Component
public class ResourceWriter {

	public ByteArrayResource export(Workbook workbook) throws IOException {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
			workbook.write(baos);
			return new ByteArrayResource(baos.toByteArray());
		}
	}
}
