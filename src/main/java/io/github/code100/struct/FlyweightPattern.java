package io.github.code100.struct;

import java.util.HashMap;

public class FlyweightPattern {
    public static void main(String[] args) {
        ChessPiece black1 = ChessPieceFactory.getPiece("黑");
        black1.display(1, 1);

        ChessPiece black2 = ChessPieceFactory.getPiece("黑");
        black2.display(2, 3);

        ChessPiece white = ChessPieceFactory.getPiece("白");
        white.display(4, 5);
    }
}

interface ChessPiece {
    void display(int x, int y);  // 外部状态由客户端传入
}

class ChessPieceImpl implements ChessPiece {
    private String color; // 内部状态：颜色

    public ChessPieceImpl(String color) {
        this.color = color;
    }

    public void display(int x, int y) {
        System.out.println("棋子颜色：" + color + "，位置：(" + x + ", " + y + ")");
    }
}

class ChessPieceFactory {
    private static final HashMap<String, ChessPiece> pieceMap = new HashMap<>();

    public static ChessPiece getPiece(String color) {
        if (!pieceMap.containsKey(color)) {
            System.out.println("创建棋子：" + color);
            pieceMap.put(color, new ChessPieceImpl(color));
        }
        return pieceMap.get(color);
    }
}