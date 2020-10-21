/*******************************************************************************
 * Minesweeper
 *
 * Copyright (C) 2018 by Martin P. Robillard
 *     
 * See: https://github.com/prmr/Minesweeper
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package ca.mcgill.cs.swevo.minesweeper;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Starting point for the application.
 */
public class Minesweeper extends Application
{
	private static final int PADDING = 1;
	private static final int NUMBER_OF_ROWS = 8;
	private static final int NUMBER_OF_COLUMNS = 20;
	private static final int NUMBER_OF_MINES = 20;
	private static final int FONT_SIZE_STATUS_BAR = 16;
	private static final int FONT_SIZE_STATUS_TILE = 14;
	private static final Insets INSETS_STATUS_BAR = new Insets(5, 0, 0, 8);
	private static final String TILE_STYLE_HIDDEN = 
			"-fx-background-radius: 0;  -fx-pref-width: 22px; -fx-pref-height: 22px;" +
			"-fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-font-size: 12; " +
			"-fx-text-fill: red; -fx-font-weight: bold;";
	private static final String TILE_STYLE_REVEALED = 
			"-fx-pref-width: 22px; -fx-pref-height: 22px; -fx-border-width: 0; -fx-border-color: black;" +
			"-fx-background-color: lightgrey;";
	
	private Minefield aMinefield;
	private GridPane aGrid;
	private Label aStatusBar;
	
	/**
	 * Launches the application.
	 * @param pArgs This program takes no argument.
	 */
	public static void main(String[] pArgs) 
	{
        launch(pArgs);
    }
	
    @Override
    public void start(Stage pStage) 
    {
    	prepareStage(pStage);
        pStage.setScene(createScene());
        newGame();
        refresh();
        pStage.show();
        aGrid.requestFocus();
    }
    
    private void prepareStage(Stage pStage) 
	{
    	pStage.setTitle("Minesweeper");
    	pStage.setResizable(false);
	}
    
    private void newGame()
    {
    	aMinefield = new Minefield(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, NUMBER_OF_MINES);
    	refresh();
    }
    
    private void refresh()
    {
    	aGrid.getChildren().clear();
    	aGrid.requestFocus();
    	for( Position position : aMinefield.getAllPositions() )
    	{
    		aGrid.add(createTile(position), position.getColumn(), position.getRow());
    	}
    	Minefield.MinefieldStatus status = aMinefield.getStatus();
    	if( status == Minefield.MinefieldStatus.CLEARED )
    	{
    		aStatusBar.setText("You won! Press Enter to play again");
    	}
    	else if( status == Minefield.MinefieldStatus.EXPLODED )
    	{
    		aStatusBar.setText("You lost. Press Enter to try again");
    	}
    	else
    	{
    		aStatusBar.setText(aMinefield.getNumberOfMinesLeft() + " mines left");
    	}
    }
	
	private Scene createScene() 
	{
		BorderPane root = new BorderPane();
		aStatusBar = new Label();
		aStatusBar.setFont(new Font("Arial", FONT_SIZE_STATUS_BAR));
		BorderPane.setMargin(aStatusBar, INSETS_STATUS_BAR);
		root.setTop(aStatusBar);
		aGrid = new GridPane();
		root.setCenter(aGrid);
		aGrid.setHgap(1);
		aGrid.setVgap(1);
		aGrid.setAlignment(Pos.CENTER);
		aGrid.setPadding(new Insets(PADDING));

		root.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			@Override
			public void handle(final KeyEvent pEvent)
			{
				if( pEvent.getCode() == KeyCode.ENTER || pEvent.getCode() == KeyCode.R)
				{
					newGame();
					refresh();
				}
				// else if ( pEvent.getCode() == KeyCode.S ) aMinefield.revealAll();
				pEvent.consume();
			}
		});
		 
		return new Scene(root);
	}
	
	private Node createTile(Position pPosition)
	{
		if( aMinefield.isRevealed(pPosition))
		{
			return createRevealedTile(pPosition);
		}
		else
		{
			return createHiddenTile(pPosition);
		}
	}
	
	private Button createHiddenTile(Position pPosition)
	{
		Button button = new Button();
		
		button.setMinHeight(0);
		button.setMinWidth(0);
		button.setStyle(TILE_STYLE_HIDDEN);
		if( aMinefield.isMarked(pPosition))
		{
			button.setText("!");
			button.setStyle("-fx-background-color: #ffff00; ");
		}
		button.setOnMouseClicked( e-> 
		{
			if( e.getButton() == MouseButton.SECONDARY )
			{ 
				aMinefield.toggleMark(pPosition); 
			}
			else
			{
				aMinefield.reveal(pPosition);
			}
			refresh();
		});
		return button;
	}
	
	private Label createRevealedTile(Position pPosition)
	{
		Label tile = new Label();
		tile.setMinSize(0, 0);
		tile.setStyle(TILE_STYLE_REVEALED);
		tile.setAlignment(Pos.CENTER);
		tile.setFont(new Font("Arial", FONT_SIZE_STATUS_TILE));
		if( aMinefield.isMined(pPosition) )
		{
			tile.setText("X");
		}
		else
		{
			int numberOfMinedneighbours = aMinefield.getNumberOfMinedNeighbours(pPosition);
			if( numberOfMinedneighbours == 0 )
			{
				tile.setText(" ");
			}
			else
			{
				tile.setText(Integer.toString(aMinefield.getNumberOfMinedNeighbours(pPosition)));
			}
		}
		return tile;
	}
}
