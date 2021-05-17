package it.polimi.ingsw.client.gui;


import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.utilities.Utils;
import it.polimi.ingsw.enumerations.GameMode;
import it.polimi.ingsw.messages.toServer.lobby.GameModeResponse;
import it.polimi.ingsw.messages.toServer.lobby.NicknameResponse;
import it.polimi.ingsw.messages.toServer.lobby.NumberOfPlayersResponse;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.UnaryOperator;

public class SetupSceneController {
    List<Integer> selectedLeaderCard;

    private GUI gui=null;
    private Client client=null;

    private HashMap<Control, Boolean> validationMap = new HashMap<>();
    @FXML
    private VBox vBoxIPandPORT;
    @FXML
    private VBox vBoxGameMode;
    @FXML
    private VBox vBoxNickname;
    @FXML
    private VBox vBoxNumOfPlayers;
    @FXML
    private VBox vBoxWaiting;


    @FXML
    private Label nicknameInfoLabel;
    @FXML
    private Label lastLabel;

    @FXML
    private ChoiceBox numOfPlayersChoiceBox;


    @FXML
    private Button singlePlayerButton;
    @FXML
    private Button multiPlayerButton;
    @FXML
    private Button sendNicknameButton;
    @FXML
    private Button connectButton;
    @FXML
    private Button sendNumOfPlayerButton;
    @FXML
    private Button confirmSelectionButton;
    @FXML
    private TextField ipTextField;

    @FXML
    private TextField portTextField;
    @FXML
    private TextField nicknameField;

    @FXML
    private HBox hbox;



    @FXML
    public void initialize() {
        TextFormatter<Integer> textFormatter = new TextFormatter<>(integerFilter);
        portTextField.setTextFormatter(textFormatter);
        vBoxIPandPORT.setVisible(true);
        vBoxGameMode.setVisible(false);
        vBoxNickname.setVisible(false);
        vBoxNumOfPlayers.setVisible(false);
        vBoxWaiting.setVisible(false);
        hbox.setVisible(false);
    }

    UnaryOperator<TextFormatter.Change> integerFilter = change -> {
        String newText = change.getControlNewText();
        if (newText.equals("") || newText.matches("([1-9][0-9]{0,4})")) {
            return change;
        }
        return null;
    };

    public void setGUI(GUI gui){
        this.gui=gui;
    }

    @FXML
    public void handleConnectButton(ActionEvent actionEvent) {
        client=new Client(ipTextField.getText(), Integer.parseInt(portTextField.getText()),gui);
        client.start();
    }

    @FXML
    public void handleSendNicknameButton(ActionEvent actionEvent) {
        client.sendMessageToServer(new NicknameResponse(nicknameField.getText()));
    }

    @FXML
    public void ipChanged(KeyEvent keyEvent) {
        boolean hasInsertedValidIp = Utils.IPAddressIsValid(ipTextField.getText());
        validationMap.put(ipTextField, hasInsertedValidIp);
        validateConnectFields();
    }
    @FXML
    public void portChanged(KeyEvent keyEvent) {
        boolean hasInsertedValidPort = Utils.portIsValid(Integer.parseInt(portTextField.getText()));
        validationMap.put(portTextField, hasInsertedValidPort);
        validateConnectFields();
    }
    private void validateConnectFields() {
        if (validationMap.values().stream().filter(valid -> valid.equals(Boolean.FALSE)).findFirst().orElse(true)) {
            connectButton.setDisable(false);
        } else {
            connectButton.setDisable(true);
        }
    }
    public void selectGameMode(){
        Platform.runLater( new Runnable() {
            @Override
            public void run() {
                vBoxIPandPORT.setVisible(false);
                vBoxGameMode.setVisible(true);
                vBoxNickname.setVisible(false);
                vBoxNumOfPlayers.setVisible(false);
                vBoxWaiting.setVisible(false);
            }
        });

    }
    @FXML
    public void handleSingleplayerButton(ActionEvent actionEvent) {
        client.sendMessageToServer(new GameModeResponse(GameMode.SINGLE_PLAYER));
    }
    @FXML
    public void handleMultiplayerButton(ActionEvent actionEvent) {
        client.sendMessageToServer(new GameModeResponse(GameMode.MULTI_PLAYER));
    }

    public void displayNicknameRequest(Boolean isRetry, Boolean alreadyTaken){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vBoxIPandPORT.setVisible(false);
                vBoxGameMode.setVisible(false);
                vBoxNickname.setVisible(true);
                vBoxNumOfPlayers.setVisible(false);
                vBoxWaiting.setVisible(false);
                if (!isRetry)
                    nicknameInfoLabel.setText("Insert your nickname");
                else if (isRetry && !alreadyTaken)
                    nicknameInfoLabel.setText("Your nickname was invalid, be sure to insert only valid characters (A-Z, a-z, 0-9)");
                else {
                    nicknameInfoLabel.setText("Your nickname has already been taken, insert another one");
                }
            }
        });
    }
    public void displayNumberOfPlayersRequest(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vBoxIPandPORT.setVisible(false);
                vBoxGameMode.setVisible(false);
                vBoxNickname.setVisible(false);
                vBoxNumOfPlayers.setVisible(true);
                vBoxWaiting.setVisible(false);
                //TODO default value or activate button only after choice
                numOfPlayersChoiceBox.getItems().add("2");
                numOfPlayersChoiceBox.getItems().add("3");
                numOfPlayersChoiceBox.getItems().add("4");
            }
        });
    }
    @FXML
    public void onNumOfPlayersChoiceBoxChosen(ActionEvent actionEvent) {
        String value =(String) numOfPlayersChoiceBox.getValue();
        client.sendMessageToServer(new NumberOfPlayersResponse(Integer.parseInt(value)));
    }


    @FXML
    public void nicknameChanged(KeyEvent keyEvent) {
        //TODO se si decide che serve
    }

    public void displayWaitingInTheLobbyMessage(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vBoxIPandPORT.setVisible(false);
                vBoxGameMode.setVisible(false);
                vBoxNickname.setVisible(false);
                vBoxNumOfPlayers.setVisible(false);
                vBoxWaiting.setVisible(true);
                lastLabel.setText("Waiting in the lobby..");
                confirmSelectionButton.setVisible(false);

            }
        });
    }

    public void displayPlayersReadyToStartMessage(List<String> players) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vBoxIPandPORT.setVisible(false);
                vBoxGameMode.setVisible(false);
                vBoxNickname.setVisible(false);
                vBoxNumOfPlayers.setVisible(false);
                vBoxWaiting.setVisible(true);
                String playerNames;
                String delim = "\n";
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (i < players.size() - 1)
                {
                    sb.append(players.get(i));
                    sb.append(delim);
                    i++;
                }
                sb.append(players.get(i));

                playerNames= sb.toString();
                lastLabel.setText("All the players are ready to start, players in game are:\n" + playerNames + "\n" );
                }
        });
    }

    public void displayLeaderCardsRequest(List<Integer> leaderCards,Client cLient) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lastLabel.setText(lastLabel.getText()+"\n Choose two out of the four following Leader cards:");
                confirmSelectionButton.setVisible(true);
                confirmSelectionButton.setDisable(true);
                selectedLeaderCard=new ArrayList<>();
                HashMap<Integer, ImageView> leaderCardsMap= buildCards(leaderCards);
                for(ImageView lcImage: leaderCardsMap.values()){
                    hbox.getChildren().add(lcImage);
                }
                hbox.setVisible(true);

            }
        });

    }

    private HashMap<Integer, ImageView> buildCards(List<Integer> leaderCards) {
        HashMap<Integer,ImageView> leaderCardsMap=new HashMap<>();
        leaderCards.forEach(lc->{
            ImageView lcImage= new ImageView( new Image(SetupSceneController.class.getResource("/img/Cards/LeaderCards/front/" + lc + ".png").toString()));//check toclass meaning.
            lcImage.setFitHeight(200);
            lcImage.setPreserveRatio(true);
            lcImage.setSmooth(true);
            lcImage.getStyleClass().add("cards");
            lcImage.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
                if(selectedLeaderCard.contains(lc)){
                    for(int i=0;i<selectedLeaderCard.size();i++){
                        if(selectedLeaderCard.get(i)==lc){
                            selectedLeaderCard.remove(i);
                            lcImage.setEffect(null);
                        }
                    }
                    confirmSelectionButton.setDisable(true);
                }else if (selectedLeaderCard.size()<2){
                    selectedLeaderCard.add(lc);
                    ColorAdjust colorAdjust=new ColorAdjust();
                    colorAdjust.setBrightness(0.4);
                    lcImage.setEffect(colorAdjust);
                    if(selectedLeaderCard.size()==2){
                        confirmSelectionButton.setDisable(false);
                    }
                }
            });
            leaderCardsMap.put(lc,lcImage);
        });
        return leaderCardsMap;
    }
    @FXML
    public void handleConfirmSelectionButton(){

    }

/*   Use this to avoid Thread exception


    Platform.runLater(new Runnable() {
        @Override
        public void run() {
            // Update UI here.
         }
    });


 */

}
