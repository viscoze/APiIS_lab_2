import table_processor.TableProcessor;
import table_processor.Table;
import view.MainFrame;

import java.awt.*;

class Main {

    public Main() {
        Table table = new Table();
        TableProcessor tableProcessor = new TableProcessor(table);
        new MainFrame(tableProcessor);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater( Main::new );
    }

}
