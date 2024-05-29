package boardgame;

import chess.ChessException;
import chess.ChessPiece;

public class Board
{
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns)
    {
        if(rows < 1 || rows < 1)
        {
            throw new BoardException("Erro criando tabuleiro: é necessário que haja pelo menos uma linha e uma coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows()
    {
        return rows;
    }



    public int getColumns()
    {
        return columns;
    }

    public void setColumns(int columns)
    {
        this.columns = columns;
    }

    public Piece piece(int row, int column)
    {
        if(!positionExists(row,column))
        {
        throw new BoardException("Posição não existente");
    }
        return pieces[row][column];
    }

    public Piece piece(Position position)
    {
        if(!positionExists(position)) {
            throw new BoardException("Posição não existente");
        }

        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position)
    {
        if(thereIsAPiece(position))
        {
            throw new BoardException("Já existe uma peça na posição " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private Boolean positionExists(int row, int column)
    {
        return row >= 0 && row < getRows() && columns >= 0 && column < columns;
    }

    public boolean positionExists(Position position)
    {
        return positionExists(position.getRow(), position.getColumn());
    }
    public boolean thereIsAPiece(Position position)
    {
        if(!positionExists(position))
        {
            throw new BoardException("Posição não existe");
        }
       return piece(position) != null;

    }
    public Piece removePiece(Position position)
    {
        if(!positionExists(position))
        {
            throw new ChessException("a posição indicada não existe!");
        }
        if(piece(position) == null)
        {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }




}
