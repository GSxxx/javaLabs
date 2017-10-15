package lab03.crosswordUpgraded;

public class BoardCell {

    private String letter;

    public void setContent(String content) {
        this.letter = content;
    }

    public String getContent() {
        return letter;
    }

    public void disableHorizStart(){};
    public void disableVertStart(){};
    public void disableHorizInner(){};
    public void disableVertInner(){};
    public void disableHorizEnd(){};
    public void disableVertEnd(){};
    public void enableHorizStart(){};
    public void enableVertStart(){};
    public void enableHorizInner(){};
    public void enableVertInner(){};
    public void enableHorizEnd(){};
    public void enableVertEnd(){};
}
