# Chess Validator

This is a command-line chess validator application implemented in Java. It allows users to initialize a chessboard, make moves, and validate those moves based on chess rules. The game alternates turns between White and Black players and displays the board after each valid move.

## Features

- Initializes the chessboard with all pieces in their standard positions.
- Enforces movement rules for all chess pieces:
  - Pawn
  - Knight
  - Bishop
  - Rook
  - Queen
  - King
- Detects and handles invalid moves.
- Supports capturing opponent pieces.
- Alternates turns between White and Black players.
- Displays the chessboard after each valid move.
- Allows the game to be exited at any time.

## Gameplay Rules

1. The board is an 8x8 grid with pieces represented as:
   - `WP` for White Pawns
   - `BP` for Black Pawns
   - `WR`, `WN`, `WB`, `WQ`, `WK` for White Rook, Knight, Bishop, Queen, and King respectively.
   - `BR`, `BN`, `BB`, `BQ`, `BK` for Black Rook, Knight, Bishop, Queen, and King respectively.
2. Moves are entered in the format: `start_position end_position` (e.g., `e2 e4`).
3. Input `exit` to end the game.
4. If a move is invalid, the application displays "Invalid Move" and the same player tries again.

## Input/Output Example

### Initial Board
```
BR BN BB BQ BK BB BN BR
BP BP BP BP BP BP BP BP
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
WP WP WP WP WP WP WP WP
WR WN WB WQ WK WB WN WR
```

### Sample Gameplay
#### Input:
```
e2 e4
g8 f6
d1 h5
e7 e5
```
#### Output:
```
White's turn. Enter your move (start end) or type 'exit':
e2 e4
BR BN BB BQ BK BB BN BR
BP BP BP BP BP BP BP BP
-- -- -- -- -- -- -- --
-- -- -- WP -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
WP WP WP WP -- WP WP WP
WR WN WB WQ WK WB WN WR

Black's turn. Enter your move (start end) or type 'exit':
g8 f6
BR BN BB BQ BK BB -- BR
BP BP BP BP BP BP BP BP
-- -- -- -- -- -- -- BN
-- -- -- WP -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
WP WP WP WP -- WP WP WP
WR WN WB WQ WK WB WN WR
```

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/chess-validator.git
   ```
2. Navigate to the project directory:
   ```bash
   cd chess-validator
   ```
3. Compile the Java code:
   ```bash
   javac ChessValidator.java
   ```
4. Run the application:
   ```bash
   java ChessValidator
   ```

## How It Works

1. The `ChessBoard` class handles board initialization, printing, and updates.
2. The `ChessGame` class manages gameplay logic, including turn management, input validation, and move execution.
3. The `ChessValidator` class contains the `main` method, serving as the entry point for the application.

## Future Enhancements

- Implement check, checkmate, and stalemate detection.
- Add castling and en passant rules.
- Support saving and loading game states.
- Develop a graphical user interface (GUI).
