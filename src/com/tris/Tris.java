package com.tris;


public class Tris {
    private String lastSign= "";
    private String[][] board;
    private int numberOfTurn=0;

    public Tris() {
        this.board = new String[3][3];
        for (int i=0;i<3;i++){
            for(int j=0; j<3;j++){
                board[i][j]=" ";
            }
        }
        }

    public String getX() {
        return "x";
    }

    public String getO() {
        return "o";
    }

    public String setSign(int x, int y, String sign) {
        String result = "";
        try {
            if ((getX().equalsIgnoreCase(sign) || getO().equalsIgnoreCase(sign))) {
                if (numberOfTurn == 0) {
                    board[x][y] = sign;
                    lastSign = sign;
                    numberOfTurn++;
                    return result + "Turn:" + numberOfTurn + " YOU INSERT " + sign + " AT POSITION " + x + "," + y + "\n" + toString();
                }
                else if (getWinner().equalsIgnoreCase("PLAYER X WIN") || getWinner().equalsIgnoreCase("PLAYER O WIN")) {
                    return result + "GAME OVER. START NEW GAME";
                }
                else if (!sign.equals(lastSign)) {
                    if (board[x][y].equals("")) {
                        board[x][y] = sign;
                        lastSign = sign;
                        numberOfTurn++;
                        String verify = getWinner();
                        if (verify.equalsIgnoreCase("PLAYER X WIN") || verify.equalsIgnoreCase("PLAYER O WIN")) {
                            return "Turn:" + numberOfTurn + " YOU INSERT " + sign + " AT POSITION " + x + "," + y + "\n" + verify + "\n" + toString();
                        }
                        if (numberOfTurn == 9)
                            return result + "Turn:" + numberOfTurn + " YOU INSERT " + sign + " AT POSITION " + x + "," + y + "\nYOU DRAW\n" + toString();
                        else
                            return result + "Turn:" + numberOfTurn + " YOU INSERT " + sign + " AT POSITION " + x + "," + y + "\n" + toString();
                    } else return result + "BUSY PLACE";
                } else return result + "IT'S NOT YOUR TURN";
            }
            else return result + "YOU INSERT WRONG SIGN";
        } catch (Exception exc) {
            System.out.println("INSERT WRONG, PLEASE RETRY");
        }
        return result;
    }

    private String getWinner()
    {
        int k = 0;
        int h = 0;
        // Test if  tris is right in some row or column
        for(int i=0; i<3; i++)
        {
            for (int j=0; j<3 ; j++)
            {
                if(board[i][j].equalsIgnoreCase("x"))
                {
                    k++;
                    if(k==3){ return "PLAYER X WIN"; }
                }
                else if(board[i][j].equalsIgnoreCase("o"))
                    {
                        h++;
                        if(h==3){ return "PLAYER O WIN"; }
                    }
                else if(board[j][i].equalsIgnoreCase("x"))
                {
                    k++;
                    if(k==3){ return "PLAYER X WIN"; }
                }
                else if(board[j][i].equalsIgnoreCase("o"))
                {
                    h++;
                    if(h==3){ return "PLAYER O WIN"; }
                }


            }
            k=0;
            h=0;
        }

        // Test if tris is right on diagonal
        for(int i=0; i<3; i++)
        {
            if(board[i][i].equalsIgnoreCase("x"))
            {
                k++;
                if(k==3){ return "PLAYER X WIN"; }
            }
            else
            {
                if(board[i][i].equalsIgnoreCase("o"))
                {
                    h++;
                    if(h==3){ return "PLAYER O WIN"; }
                }
            }
        }
        k=0;
        h=0;
        int j = 2;
        for(int i=0; i<3; i++)
        {
            if(board[i][j].equalsIgnoreCase("x"))
            {
                k++;
                if(k==3){ return " PLAYER X WIN "; }
            }
            else
            {
                if(board[i][j].equalsIgnoreCase("o"))
                {
                    h++;
                    if(h==3){ return " PLAYER O WIN "; }
                }
            }
            j--;
        }
        return "" ;
    }


    @Override
    public String toString() {
        StringBuilder printBoard= new StringBuilder();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                printBoard.append("| ").append(board[i][j]).append(" |");
            }
            printBoard.append("\n");
        }
        return printBoard.toString();
    }
}

