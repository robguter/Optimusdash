package main.controladores;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import main.util.OnOffButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {

    AnchorPane srcPane = FXMLLoader.load(getClass().getResource("../vistas/inicio.fxml"));
    String strPath, strTitle = "";

    @FXML
    private Pane pnlIzq;

    @FXML
    private VBox vbxPnlIzq, vbxBusca;

    @FXML
    private JFXButton btnMenu, btnCartOpt, btnAnaCartOpt,
                      btnRastrea, btnPondera, btnClose;

    @FXML
    private FontAwesomeIcon aweMnu, aweCrt, aweAna, aweRst, awePnd;

    @FXML
    private FontAwesomeIcon awePln, aweGsi, aweCnb, aweCmg, aweCnf, aweExt;

    @FXML
    private Pane pnlSup;

    @FXML
    private Pane pnlCntn;

    double a1, a3 = 0.0;

    public mainController() throws IOException {
    }

    @FXML
    public void handleClick(ActionEvent e) throws IOException {
        if (e.getSource() == btnMenu) {
            ajstMnu();
            return;
        }else if (e.getSource() == btnCartOpt) {
            srcPane = FXMLLoader.load(getClass().getResource("../vistas/cartopt.fxml"));
            strTitle = "Cartera Óptima";
        }else if (e.getSource() == btnAnaCartOpt) {
            srcPane = FXMLLoader.load(getClass().getResource("../vistas/anacartopt.fxml"));
            strTitle = "Análisis Cartera Óptima";
        }else if (e.getSource() == btnRastrea) {
            srcPane = FXMLLoader.load(getClass().getResource("../vistas/rastrea.fxml"));
            strTitle = "Rastreador";
        }else if (e.getSource() == btnPondera) {
            srcPane = FXMLLoader.load(getClass().getResource("../vistas/pondera.fxml"));
            strTitle = "Ponderador";
        }else if (e.getSource() == btnClose) {
            Boolean Resp = app.util.ConfirmBox.display("Verifique su respuesta","Realmente desea salir");
            if (Resp == true) {
                System.exit(0);
            }
        }
        srcPane.prefWidth(this.pnlCntn.getWidth());
        srcPane.prefHeight(this.pnlCntn.getHeight());
        srcPane.setMinWidth(this.pnlCntn.getWidth());
        srcPane.setMinHeight(this.pnlCntn.getHeight());

        this.pnlCntn.getChildren().setAll(srcPane);
    }
    private void ajstMnu() {
        ContentDisplay cnt;
        String a2;
        if (pnlIzq.getPrefWidth() == 140) {
            cnt = ContentDisplay.GRAPHIC_ONLY;
            a1 = 50;
            a2 = "1.25em";
            a3 = 1650;
            vbxBusca.setVisible(false);
        }else{
            cnt = ContentDisplay.TOP;
            a1 = 140;
            a2 = "2.0em";
            a3 = 1520;
            vbxBusca.setVisible(true);
        }
        btnCartOpt.setContentDisplay(cnt);
        btnPondera.setContentDisplay(cnt);
        btnRastrea.setContentDisplay(cnt);
        btnAnaCartOpt.setContentDisplay(cnt);

        pnlIzq.setPrefWidth(a1);
        vbxPnlIzq.setPrefWidth(a1);
        pnlCntn.setLayoutX(a1);
        srcPane.setLeftAnchor(pnlCntn, a1);

        aweMnu.setSize(a2);
        aweCrt.setSize(a2);
        aweAna.setSize(a2);
        aweRst.setSize(a2);
        awePnd.setSize(a2);

        pnlCntn.setPrefWidth(a3);
        pnlCntn.setMaxWidth(a3);
        pnlCntn.setMinWidth(a3);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        strTitle = "Panel Principal";
        srcPane.setPrefWidth(this.pnlCntn.getPrefWidth());
        srcPane.setMinHeight(this.pnlCntn.getHeight());
        srcPane.setMaxWidth(this.pnlCntn.getMaxWidth());
        srcPane.setMinWidth(this.pnlCntn.getMinWidth());
        srcPane.setMaxHeight(this.pnlCntn.getHeight());

        OnOffButton btnSwich = new OnOffButton();
        btnSwich.setTranslateX(0);
        btnSwich.setTranslateY(0);
        vbxBusca.getChildren().add(btnSwich);

        this.pnlCntn.getChildren().setAll(srcPane);
    }
}
