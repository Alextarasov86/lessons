package homework.myGame2;

public class Game {
    Command startNewGame;
    Command returnToGame;
    Command save;
    Command load;
    Command exit;
    Command returnToMenu;
    Command choice;
    boolean isSave;

    public Game(Command startNewGame, Command returnToGame, Command save,
                Command load, Command exit, Command returnToMenu, Command choice) {
        this.startNewGame = startNewGame;
        this.returnToGame = returnToGame;
        this.save = save;
        this.load = load;
        this.exit = exit;
        this.returnToMenu = returnToMenu;
        this.choice = choice;
    }

    void startNewGame(){ startNewGame.execute();}
    void returnToGame(){ returnToGame.execute();}
    void saveGame(){save.execute();}
    void loadGame(){load.execute();}
    void exitGame(){exit.execute();}
    void returnToMenuGame(){returnToMenu.execute();}
    void choiceContinueGame(){choice.execute();}
    void printMenu(){
        System.out.println("Добро пожаловать в игру. Выберите пункт меню: ");
        System.out.println("1. Начать игру");
        System.out.println("2. Вернуться в игру");
        System.out.println("3. Сохранить игру");
        if(isSave){
            System.out.println("4. Загрузить игру");
            System.out.println("5. Выйти из игры");
        } else{
            System.out.println("4. Выйти из игры");
        }

    }
}
