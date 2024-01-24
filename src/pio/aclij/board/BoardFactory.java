package pio.aclij.board;

import pio.aclij.board.fen.FenHandler;

public class BoardFactory {

    public static Board fromFen(String fen){
        return FenHandler.decode(fen);
    }

}
