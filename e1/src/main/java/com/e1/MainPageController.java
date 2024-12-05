package com.e1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

// Classes para comunicação com o banco
import java.sql.SQLException;
import java.util.List;

public class MainPageController {
    @FXML
    private TextField guitarraMarcaTextField;
    @FXML
    private TextField guitarraModeloTextField;
    @FXML
    private TextField guitarraCorTextField;
    @FXML
    private TextField guitarraCordasTextField;
    @FXML
    private TableView<Guitarra> guitarraTableView;
    @FXML
    private TableColumn<Guitarra, Integer> idColumn;
    @FXML
    private TableColumn<Guitarra, String> marcaColumn;
    @FXML
    private TableColumn<Guitarra, String> modeloColumn;
    @FXML
    private TableColumn<Guitarra, String> corColumn;
    @FXML
    private TableColumn<Guitarra, String> cordasColumn;

    // Vínculo com o arquivo de comunicação com o banco
    private Database database;
    private ObservableList<Guitarra> guitarraObservableList;

    @FXML
    public void initialize() {
        database = new Database();
        guitarraObservableList = FXCollections.observableArrayList();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        marcaColumn.setCellValueFactory(new PropertyValueFactory<>("marcaG"));
        modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modeloG"));
        corColumn.setCellValueFactory(new PropertyValueFactory<>("corG"));
        cordasColumn.setCellValueFactory(new PropertyValueFactory<>("cordaG"));

        guitarraTableView.setItems(guitarraObservableList);

        carregarGuitarras();
    }


    private void carregarGuitarras() {
        try {
            List<Guitarra> guitarras = database.listarGuitarras();
            guitarraObservableList.setAll(guitarras);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void salvarGuitarra() {
        try {
            Guitarra guitarra = new Guitarra(0, guitarraMarcaTextField.getText(), guitarraModeloTextField.getText(), guitarraCorTextField.getText(), guitarraCordasTextField.getText());
            database.inserirGuitarra(guitarra);
            carregarGuitarras();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Guitarra salva com sucesso!");
            alert.showAndWait();

            limparCampos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void atualizarGuitarra() {
        Guitarra guitarra = guitarraTableView.getSelectionModel().getSelectedItem();
        if (guitarra != null) {
            try {
                guitarra.setMarcaG(guitarraMarcaTextField.getText());
                guitarra.setModeloG(guitarraModeloTextField.getText());
                guitarra.setCorG(guitarraCorTextField.getText());
                guitarra.setCordaG(guitarraCordasTextField.getText());
                database.atualizarGuitarra(guitarra);
                carregarGuitarras();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informação");
                alert.setHeaderText(null);
                alert.setContentText("Guitarra atualizada com sucesso!");
                alert.showAndWait();

                limparCampos();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void deletarGuitarra() {
        Guitarra guitarra = guitarraTableView.getSelectionModel().getSelectedItem();
        if (guitarra != null) {
            try {
                database.deletarGuitarra(guitarra.getId());
                carregarGuitarras();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informação");
                alert.setHeaderText(null);
                alert.setContentText("Guitarra deletada com sucesso!");
                alert.showAndWait();

                limparCampos();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void limparCampos() {
        guitarraMarcaTextField.clear();
        guitarraModeloTextField.clear();
        guitarraCorTextField.clear();
        guitarraCordasTextField.clear();
    }
}
