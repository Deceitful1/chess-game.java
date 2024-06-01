package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (true) {
            try {
                for (int i = 0; i < 30; i++) {
                    System.out.println();
                }


             UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");

                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possilbleMoves(source);
                for (int i = 0; i < 30; i++) {
                    System.out.println();
                }
                UI.printBoard(chessMatch.getPieces(), possibleMoves);


                System.out.println();
                System.out.print("Target ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.perfomChessMove(source, target);
                if(capturedPiece != null)
                {
                    captured.add(capturedPiece);
                }
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException i) {
                System.out.println(i.getMessage());
                sc.nextLine();
            } catch (ArrayIndexOutOfBoundsException a) {
                System.out.println(a.getMessage());
            }

        }

    }
}