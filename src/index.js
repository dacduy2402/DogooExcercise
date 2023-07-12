import React from "react";
import ReactDOM from "react-dom";
import "./index.css";

function Square(props) {
  return (
    <button className="square" onClick={props.onClick}
    style={{ background: props.isWinning ? "#00FF00" : "" }}>
      {props.value}
    </button>
  );
}

class Board extends React.Component {
  renderSquare(i, isWinningSquare) {
    return (
      <Square
        key = {i}
        value={this.props.squares[i]}
        onClick={() => this.props.onClick(i)}
        isWinning = {isWinningSquare}
      />
    );
  }

  render() {
    let squares = [];
    const boardSize = 3;
    for (let row = 0; row < boardSize; row++) {
        let rowSquares = []
        for (let col = 0; col < boardSize; col++) {
            const index = row * boardSize + col;
            const isWinningSquare = this.props.winningSquares ? this.props.winningSquares.includes(index) : false;
            rowSquares.push(this.renderSquare(index, isWinningSquare));
        }
        squares.push(<div key={row} className="board-row">{rowSquares}</div>);
    }
    return <div>{squares}</div>;
  }
}

class Game extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      history: [
        {
          squares: Array(9).fill(null),
          position: null,
        },
      ],
      stepNumber: 0,
      xIsNext: true,
      flag: true
    };
  }

  handleClick(i) {
    const history = this.state.history.slice(0, this.state.stepNumber + 1);
    const current = history[history.length - 1];
    const squares = current.squares.slice();
    if (calculateWinner(squares) || squares[i]) {
      return;
    }
    squares[i] = this.state.xIsNext ? "X" : "O";
    this.setState({
      history: history.concat([
        {
          squares: squares,
          position: i,
        },
      ]),
      stepNumber: history.length,
      xIsNext: !this.state.xIsNext,
    });
  }

  jumpTo(step) {
    this.setState({
      stepNumber: step,
      xIsNext: step % 2 === 0,
    });
  }

  clickToggle(){
    this.setState({
      flag: !this.state.flag
    });
     
  }

  render() {
    const history = this.state.history;
    const current = history[this.state.stepNumber];
    const winnerInfo = calculateWinner(current.squares);
    const moves = history.map((step, move) => {
      const positionSquare = step.position;
      const col = (positionSquare % 3) + 1;
      const row = Math.floor(positionSquare / 3) + 1;
      const desc = move
        ? `Go to move #${move} (cột: ${col}, hàng: ${row})`
        : "Go to game start";
      // const toggle = moves.reverse();
      return (
        <div>
          <li key={move}>
            <button onClick={() => this.jumpTo(move)}>
                {move === this.state.stepNumber ? <b>{desc}</b> : desc}
            </button>
          </li>
        </div>
      );
    });

    if (!this.state.flag) {
      moves.reverse();
    }

    let status;
    let winningSquares;
    if (winnerInfo) {
      status = "Winner: " + winnerInfo.winner;
      winningSquares = winnerInfo.line;
    } else if (history.length === 10) {
      status = "Draw";
    } else {
      status = "Next player: " + (this.state.xIsNext ? "X" : "O");
    }
    return (
      <div className="game">
        <div className="game-board">
          <Board
            squares={current.squares}
            onClick={(i) => this.handleClick(i)}
            winningSquares = {winningSquares}
          />
        </div>
        <div className="game-info">
          <div>{status}</div>
          <button onClick={() => this.clickToggle(moves)}>Toggle Sort</button>
          <ol>{moves}</ol>
        </div>
      </div>
    );
  }
}
ReactDOM.render(<Game></Game>, document.getElementById("root"));

function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i];
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
      return {
        winner: squares[a],
        line: [a, b, c]
      }
    }
  }
  return null;
}