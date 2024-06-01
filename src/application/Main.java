package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                for (int i = 0; i < 30; i++) {
                    System.out.println();
                }


             UI.printMatch(chessMatch);
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