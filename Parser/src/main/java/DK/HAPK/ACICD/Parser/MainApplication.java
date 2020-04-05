package DK.HAPK.ACICD.Parser;

import DK.HAPK.ACICD.Parser.GUI.MainWindow;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MainApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(MainApplication.class).headless(false).run(args);
		MainWindow appFrame = context.getBean(MainWindow.class);
//		ParserWindow appFrame = context.getBean(ParserWindow.class);
		appFrame.run();
	}
}
