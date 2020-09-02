package com.suziesta;

public class Main {
    static int M = 6;
    static int N = 6;
    public static void main(String[] args) {
        char[][] mat =
                {{'X', 'O', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'}};

        replaceSurrounded(mat);

        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(mat[i][j] + " ");

            System.out.println("");
        }
    }

    private static void replaceSurrounded(char[][] mat) {
        int row = mat.length;
        int col= mat[0].length;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(mat[i][j]== 'O')
                    mat[i][j]='_';
            }
        }

        //left
        for(int i=0; i<row; i++){
            if(mat[i][0]== '_'){
                dfs(mat, i, 0);
            }
        }
        //right
        for(int i=0; i<row; i++){
            if(mat[i][col-1]== '_'){
                dfs(mat, i, col-1);
            }
        }
        //top
        for(int i=0; i<col; i++){
            if(mat[0][i]== '_'){
                dfs(mat, 0, i);
            }
        }
        //bottom
        for(int i=0; i<col; i++){
            if(mat[row-1][i]== '_'){
                dfs(mat, row-1, i);
            }
        }

        for(int i=0;i<row; i++){
            for(int j=0; j<col; j++){
                if(mat[i][j] == '_')
                    mat[i][j] = 'X';
            }
        }
    }

    private static void dfs(char[][] mat, int row, int col) {
        if(row<0 || row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] != '_'){
            return;
        }

        mat[row][col] = 'O';

        dfs(mat, row+1, col);
        dfs(mat, row-1, col);
        dfs(mat, row, col-1);
        dfs(mat, row, col+1);
    }
}
