package Controllers;

import Config.Settings;
import Services.LoginValidationService;
import Start.MainController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * Class LoginController.
 */
public class LoginController {
    /**
     * Class variables.
     */
    private boolean success, useProxy = false;

    /**
     * All used controls from Resources.Views.
     */
    public TextField username;
    public TextField password;
    public Label errorMessage;

    /**
     * mainController.
     */
    @FXML
    private MainController mainController;

    /**
     * Set start function.
     * <p>
     * This function is used to set the maincontroller and to manipulate the Resources.Views
     *
     * @param mainController MainController
     */
    @FXML
    public void setStart(MainController mainController) {
        this.mainController = mainController;
        boolean err = new LoginValidationService().error;

        if (Settings.proxy.useProxy) {
            this.errorMessage.setText("Proxysettings activated");
        } else if (!err || Settings.proxy.useProxy) {
            this.errorMessage.setText("Invalid Credentials");
        } else {
            this.errorMessage.setText("Proxysettings deactivated");
        }


    }

    /**
     * Handle registration.
     *
     * Go to the registration screen.
     */
    @FXML
    private void registrationLinkOnClick() {
        mainController.initRegisterGui();
    }

    /**
     * Handle login.
     *
     * This function takes the values from the input fields and sends them to the server-function. If the server
     * response is okay, the user is redirected to the start screen
     */
    @FXML
    private void loginButtonOnClick() {
        String username = this.username.getText();
        String password = this.password.getText();

        LoginValidationService loginValServ = new LoginValidationService();

        if (loginValServ.isLoginValid(username, password)) {
            mainController.initStartGui();
        } else {
            this.password.setText("");
        }
    }

    /**
     * Handle Proxy settings.
     *
     * This function changes the boolean state of the useProxy variable. Afterwards, there is a response displayed
     */
    @FXML
    private void proxyLinkOnClick() {
        if (useProxy) {
            Settings.proxy.useProxy = false;
        } else {
            Settings.proxy.useProxy = true;
        }

        if (this.success) {
            this.success = false;
        } else {
            this.success = true;
        }
        this.setStart(mainController);
    }
}