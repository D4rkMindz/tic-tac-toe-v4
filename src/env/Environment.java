package env;

public class Environment {
    public String loginUrl = "http://localhost/tic-tac-toe/tictactoe-server/login.php";
    public String registerUrl = "http://localhost/tic-tac-toe/tictactoe-server/register.php";
//    public String playersUrl = "http://localhost/tic-tac-toe/tictactoe-server/register.php";

//    public String loginUrl = "http://localhost/tictactoe/login.php";
//    public String registerUrl = "http://localhost/tictactoe/register.php";
//
//    public String loginUrl = "http://files.d4rkmindz.ch/login.php";
//    public String registerUrl = "http://files.d4rkmindz.ch/register.php";

    public String getLoginUrl(){
        return loginUrl;
    }

    public String getRegisterUrl(){
        return registerUrl;
    }
}
