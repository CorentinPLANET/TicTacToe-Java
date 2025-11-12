import java.util.Scanner;

class TicTacToe {
   public static char[][] board = {
         { '.', '.', '.' },
         { '.', '.', '.' },
         { '.', '.', '.' },
   };
   public static Scanner scan = new Scanner(System.in);

   public static char symbol = 'x';

   public static void display() {
      // forEach loop: eachLine = ligne du tableau
      for (char[] eachLine : board) {
         System.out.println(eachLine);
      }
   }

   public static int checkPos(String axis) {
      while (true) {
         System.out.println("Veuillez entre la " + axis + " de votre symbole :");
         try {
            int pos = scan.nextInt();
            if (pos <= 2 && pos >= 0) {
               return pos;
            } else {
               System.out.println("Vous avez entrer un numero de " + axis + " invalide");
               scan.nextLine();
            }
         } catch (Exception NaN) {
            System.out.println("Une erreur est survenue, veuillez reessayer");
            scan.nextLine();
         }

      }
   }

   public static boolean checkWin(char[][] board) {
      for (int i = 0; i < board.length; i++) {
         if (board[i][0] == 'x' && board[i][1] == 'x' && board[i][2] == 'x') {
            System.out.println("x wins ");
            return true;
         } else if (board[i][0] == 'o' && board[i][1] == 'o' && board[i][2] == 'o') {
            System.out.println("o wins ");
            return true;
         }
         if (board[0][i] == 'x' && board[1][i] == 'x' && board[2][i] == 'x') {
            System.out.println("x wins ");
            return true;
         } else if (board[0][i] == 'o' && board[1][i] == 'o' && board[2][i] == 'o') {
            System.out.println("o wins ");
            return true;
         }
      }
      if (board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') {
         System.out.println("x wins ");
         return true;
      } else if (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o') {
         System.out.println("o wins ");
         return true;
      }
      if (board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x') {
         System.out.println("x wins ");
         return true;
      } else if (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o') {
         System.out.println("o wins ");
         return true;
      }
      return false;
   }

   public static boolean checkBoardFill(char[][] board) {
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board.length; j++) {
            if (board[i][j] == '.') {
               return false;
            }
         }
      }
      return true;
   }

   public static void play() {

      int column = checkPos("colonne");
      int line = checkPos("ligne");
      if (board[line][column] != '.') {
         System.out.println("Emplacement déjà utilisé, veillez réessayer");
      } else {
         board[line][column] = symbol;
         symbol = symbol == 'x' ? 'o' : 'x';
         display();
      }
      if (checkWin(board)) {
      } else if (checkBoardFill(board)) {
         System.out.println("Tous les emplacements sont utilisés, la partie est une égalité");
      } else {
         play();
      }

   }

   public static void main(String[] params) {
      display();
      play();
      /*
       * System.out.println("Quel est votre age ?");
       * 
       * while (true) {
       * try {
       * int age = scan.nextInt();
       * System.out.println("Votre age est : " + age);
       * break;
       * } catch (Exception e) {
       * System.out.println("Un nombre");
       * scan.nextLine();
       * }
       * }
       * scan.close();
       */
   }
}