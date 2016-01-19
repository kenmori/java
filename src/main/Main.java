package main;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
//import freemarker.template.Version;
public class Main {

	public static void main(String... args) throws IOException, TemplateException {
//		Configuration cfg = new Configuration(new Version("2.3.22"));
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);

		Path srcPath = Paths.get("./");
		cfg.setDirectoryForTemplateLoading(srcPath.toFile());
		cfg.setDefaultEncoding("UTF-8");

		Template template = cfg.getTemplate("index.ftl");

		// データモデルを定義
		Map<String, Object> dataModel = new HashMap<String, Object>();
		dataModel.put("fafa", "eeee");

		// テンプレート処理
		Path dstPath = Paths.get("/index.txt");
		Files.createDirectories(dstPath.getParent());
		try (Writer writer = Files.newBufferedWriter(dstPath, StandardCharsets.UTF_8)) {
			template.process(dataModel, writer);
		}
	}
}
