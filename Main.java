import java.awt.*;

class Main {

    public Main() {
        new MainFrame();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater( Main::new );
    }

}
