package p1400_find_winner_on_a_tic_tac_toe_game

class Solution {
    fun tictactoe(moves: Array<IntArray>): String {
        val board = IntArray(9) { -1 }
        val players = arrayOf("A", "B")
        var player = 0
        for (arr in moves) {
            val (x, y) = arr
            board[y * 3 + x] = player
            player = if (player == 0) 1 else 0
        }

        if (board[0] != -1 && board[0] == board[1] && board[1] == board[2]) return players[board[0]]
        if (board[3] != -1 && board[3] == board[4] && board[4] == board[5]) return players[board[3]]
        if (board[6] != -1 && board[6] == board[7] && board[7] == board[8]) return players[board[6]]
        if (board[0] != -1 && board[0] == board[3] && board[3] == board[6]) return players[board[0]]
        if (board[1] != -1 && board[1] == board[4] && board[4] == board[7]) return players[board[1]]
        if (board[2] != -1 && board[2] == board[5] && board[5] == board[8]) return players[board[2]]
        if (board[0] != -1 && board[0] == board[4] && board[4] == board[8]) return players[board[0]]
        if (board[2] != -1 && board[2] == board[4] && board[4] == board[6]) return players[board[2]]

        return if (board.contains(-1)) "Pending" else "Draw"
    }
}
