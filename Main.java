import table_processor.TableProcessor;
import table_processor.Table;
import view.MainFrame;

import java.awt.*;

class Main {

    public Main() {

        TableProcessor tableProcessor = new TableProcessor(new Table());
        new MainFrame();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater( Main::new );
    }

}
