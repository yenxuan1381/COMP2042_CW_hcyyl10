/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main;

import java.awt.*;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import view.GameFrame;
import view.MenuView;


public class GraphicsMain extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		
		try {
			MenuView menu = new MenuView(stage);
			
			stage.show();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Add bg image
//		Image image = new Image("file:src/resources/bg.jpg");
//		ImageView mv = new ImageView(image);
//		
//		mv.setFitHeight(550);
//		mv.setFitWidth(500);
//		mv.setPreserveRatio(true);
//		
//		Group root = new Group();
//		root.getChildren().addAll(mv);
//		
//		Scene scene = new Scene(root,450,300);
//		stage.setScene(scene);
//		stage.setResizable(false);
//		stage.show();
		
//		StackPane root = new StackPane();
//        Scene scene = new Scene(root, 430, 300);
//        Image img = new Image("file:src/resources/bg.jpg");
//        BackgroundImage bImg = new BackgroundImage(img,
//                                                   BackgroundRepeat.NO_REPEAT,
//                                                   BackgroundRepeat.NO_REPEAT,
//                                                   BackgroundPosition.DEFAULT,
//                                                   BackgroundSize.DEFAULT);
//        Background bGround = new Background(bImg);
//        root.setBackground(bGround);
//        primaryStage.setScene(scene);
//        primaryStage.show();
		
		
	}
	
    public static void main(String[] args){
//        EventQueue.invokeLater(() -> new GameFrame().initialize());
        launch(args);
    }

	

}
