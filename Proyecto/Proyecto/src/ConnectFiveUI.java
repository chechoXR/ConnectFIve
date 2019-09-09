
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

import javax.xml.transform.stream.StreamResult;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Skin;
import javafx.scene.control.SkinBase;
import javafx.scene.control.Skinnable;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Container;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
@SuppressWarnings("unused")
/**
 * 
 * @author checho
 *
 */
public class ConnectFiveUI extends Application  {


	private static Circle circulos [][] = new Circle[6][6];
	private static Button botones [][];
	private String coin ="C:/Users/checho/Documents/Universidad/Semestre-VI/Ingenieria de Softwre I/Proyecto/Sonidos/Coin";
	private static final String avatarPath="C:/Users/checho/Documents/Universidad/Semestre-VI/Ingeniería de Softwre I/Proyecto/Avatares";

	public static void main(String[] args) {

		Application.launch();
	}


	@Override
	public void start(Stage primaryStage) throws Exception {

		//__________________________HOME_______________________________________________________
		//_____________________________________________________________________________________
		//_____________________________________________________________________________________

		Stage home = new Stage();
		Pane homep = new Pane();

		Button i1 = new Button("Home");
		Button i2 = new Button("Home");
		Button i3 = new Button("Home");

		i1.setShape(new Ellipse(8,5));
		i2.setShape(new Ellipse(8,5));
		i3.setShape(new Ellipse(8,5));

		i1.setTranslateX(0);
		i1.setTranslateY(15);

		//Tamaño ventana
		homep.setMinSize(730, 500);
		homep.setBackground(Background.EMPTY);







		Scene homesc = new Scene(homep,Color.rgb(40, 133, 210));
		//No se puede maximizar
		home.setResizable(false);
		home.setTitle("Home");
		home.centerOnScreen();
		home.setScene(homesc);
		home.initStyle( StageStyle.UNDECORATED );
		home.show();

		Label title = new Label("¡CONECTA CINCO EN LINEA!");
		title.setFont(Font.font("Comic Sans MS",25));

		//Lugar del titulo
		title.setTranslateX(190);		
		title.setTranslateY(25);


		Label n1 = new Label("Nombre del primer jugador:");
		Label n2 = new Label("Nombre del segundo jugador:");

		TextField name1 = new TextField();
		TextField name2 = new TextField();

		Label a1 = new Label("Avatar del primer jugador:");
		Label a2 = new Label("Avatar del segundo jugador:");



		ComboBox<String> av1 = new ComboBox<String>();
		ComboBox<String> av2 = new ComboBox<String>();

		Button close = new Button("");
		Circle cl = new Circle(1, Color.RED);
		close.setShape(cl);

		close.setMinSize(25, 23);
		close.setStyle("-fx-background-color: #F34E48; ");
		close.setTranslateX(5);
		close.setTranslateY(5);

		close.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				home.close();
			}

		});

		close.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				close.setText("X");

			}
		});

		close.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				close.setText("");

			}
		});

		Button Minimize = new Button("");
		Minimize.setShape(cl);

		Minimize.setMinSize(25, 23);
		Minimize.setStyle("-fx-background-color: #ABE581; ");
		Minimize.setTranslateX(35);
		Minimize.setTranslateY(5);
		home.setIconified(false);

		Minimize.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				Minimize.setText("-");

			}
		});

		Minimize.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				Minimize.setText("");

			}
		});



		Minimize.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				home.setIconified(true);
			}

		});


		File folder = new File(avatarPath);

		for (File f : folder.listFiles()) {
			System.out.println(f.getName());
			StringTokenizer st = new StringTokenizer(f.getName(), ".");
			String s= st.nextToken();
			av1.getItems().add(s);
			av2.getItems().add(s);
		}
		av1.getItems().add("Aleatorio");
		av2.getItems().add("Aleatorio");

		n1.setTranslateX(20);
		n1.setTranslateY(200);

		n2.setTranslateX(20);
		n2.setTranslateY(240);

		name1.setPrefSize(180, 20);
		name1.setTranslateX(175);
		name1.setTranslateY(195);

		name2.setPrefSize(170, 20);
		name2.setTranslateX(185);
		name2.setTranslateY(235);

		Button play = new Button("¡A Jugar!");
		Button puntajes = new Button("Records");
		Button credits = new Button("Créditos");

		play.resize(60, 20);
		puntajes.resize(60, 20);
		credits.resize(60, 20);

		play.setTranslateX(330);
		play.setTranslateY(290);

		puntajes.setTranslateX(332);
		puntajes.setTranslateY(335);

		credits.setTranslateX(330);
		credits.setTranslateY(380);


		a1.setTranslateX(360);
		a1.setTranslateY(200);
		av1.setTranslateX(510);
		av1.setTranslateY(200);

		a2.setTranslateX(360);
		a2.setTranslateY(240);
		av2.setTranslateX(510);
		av2.setTranslateY(240);

		Circle yellow = new Circle(60,Color.YELLOW);
		Circle red = new Circle(60,Color.RED);

		yellow.setTranslateX(310);
		yellow.setTranslateY(120);

		red.setTranslateX(380);
		red.setTranslateY(120);

		homep.getChildren().add(title);
		homep.getChildren().add(n1);
		homep.getChildren().add(n2);
		homep.getChildren().add(name1);
		homep.getChildren().add(name2);
		homep.getChildren().add(play);
		homep.getChildren().add(puntajes);
		homep.getChildren().add(credits);
		homep.getChildren().add(a1);
		homep.getChildren().add(a2);
		homep.getChildren().add(av1);
		homep.getChildren().add(av2);
		homep.getChildren().add(close);
		homep.getChildren().add(Minimize);
		homep.getChildren().add(yellow);
		homep.getChildren().add(red);


		//_____________________________________________________________________________________
		//_____________________________________________________________________________________
		//_________________________/HOME_______________________________________________________



		//__________________________Records_______________________________________________________
		//_____________________________________________________________________________________
		//_____________________________________________________________________________________

		Stage R = new Stage(); 
		Pane records = new Pane();
		Scene recordsSC = new Scene(records,Color.rgb(40, 133, 210));
		R.setScene(recordsSC);
		R.setResizable(false);
		R.initStyle( StageStyle.UNDECORATED );
		records.setMinSize(680, 500);
		records.setBackground(Background.EMPTY);
		Label tRecord = new Label("RECORDS!");


		tRecord.setTranslateX(270);
		tRecord.setTranslateY(30);
		records.getChildren().add(tRecord);
		//		records.setContent(tRecord);
		tRecord.setFont(Font.font("Showcard Gothic", 28));


		Label titulos [] = new Label[5];

		titulos [0] = new Label("Puntaje");
		titulos [1] = new Label("Nombre");
		titulos [2] = new Label("Color");
		titulos [3] = new Label("Fecha");
		titulos [4] = new Label("Avatar");



		int c=0;
		for (int i = 0; i< titulos.length; i++) {
			c+=70;	
			titulos[i].setFont(Font.font(13));
			titulos[i].setTranslateX(c);
			titulos[i].setTranslateY(100);
			records.getChildren().add(titulos[i]);
			//			records.setContent(titulos[i]);
			titulos[i].setFont(Font.font("Showcard Gothic")); 
		}




		Conexion con= new Conexion();
		String scores="select * from scores order by puntaje desc";

		ResultSet datos=null;
		boolean sec=false;
		try {

			datos= Conexion.buscar(scores);
			sec=true;
		} catch (Exception e) {



		}




		int d=130;
		while(sec && datos.next()) {
			Label resultados [] = new Label[5];



			c=0;
			for (int i = 0; i< resultados.length;i++) {
				resultados[i]=new Label();

				Separator s = new Separator(Orientation.HORIZONTAL);
				s.setMinWidth(620);
				s.setTranslateX(50);
				s.setTranslateY(d-10);

				resultados[i].setFont(Font.font(13));
				c+=70;
				resultados[i].setTranslateX(c);
				resultados[i].setTranslateY(d);
				
				if(i!=resultados.length-1)
					records.getChildren().addAll(resultados[i],s);
				else
				{
					resultados[i].setText(datos.getString(i+1));
					System.out.println("RESultadoSS!!!"+resultados[i].getText());
					Image img = new Image(new FileInputStream(resultados[i].getText()));
					ImageView avt = new ImageView(img);
					avt.setFitHeight(15);
					avt.setFitWidth(15);
					
					avt.setTranslateX(c);
					avt.setTranslateY(d);
					records.getChildren().addAll(avt,s);
				}
				//				records.setContent(resultados[i]);
				//				records.setContent(s);
				resultados[i].setFont(Font.font("Showcard Gothic"));
			}
			d+=30;

			try {
				for (int i = 1; i <= resultados.length; i++) 
					resultados[i-1].setText(datos.getString(i));

			} catch (Exception e) {
				e.printStackTrace();
			}



			//					System.out.println(datos.getString(1)+" "+datos.getString(2)+" "+datos.getString(3)+" "+datos.getString(4)+" "+datos.getString(5)+" "+datos.getString(6)+" "+datos.getString(7));
		}











		//__________________________/records_______________________________________________________
		//_____________________________________________________________________________________
		//_____________________________________________________________________________________







		//__________________________GAME_______________________________________________________
		//_____________________________________________________________________________________
		//_____________________________________________________________________________________

		ConnectFiveLogic.StartConnectFiveLogic();
		Pane game = new Pane();
		//Tamaño de la ventana
		//		p.setLayoutX(550);
		//		p.setLayoutY(500);

		//		p.setMinWidth(500);
		//		p.setMinHeight(500);
		game.setMinSize(500, 500);
		game.setBackground(Background.EMPTY);

		Scene sc = new Scene(game,Color.rgb(40, 133, 210));

		//		System.out.println(p.getWidth()+"   "+ p.getHeight());


		//No se puede maximizar
		primaryStage.setResizable(false);
		primaryStage.setTitle("ConnectFive");
		primaryStage.centerOnScreen();
		primaryStage.setScene(sc);
		primaryStage.initStyle( StageStyle.UNDECORATED );



		Button restart = new Button("Reiniciar");
		restart.setShape(new Ellipse(8,5));
		restart.setTranslateX(460);
		restart.setTranslateY(15);
		game.getChildren().add(restart);

		Circle player1ICO = new Circle(14,Color.YELLOW);
		Circle player2ICO = new Circle(14,Color.RED);
		Label player1L = new Label();
		Label player2L = new Label();

		//Tamaño fuente label nombres de jugadores
		player1L.setFont(Font.font(20));
		player2L.setFont(Font.font(20));

		//Posicion convenciones de jugadores
		player1ICO.setTranslateX(130);
		player1ICO.setTranslateY(25);

		player2ICO.setTranslateX(280);
		player2ICO.setTranslateY(25);

		player1L.setTranslateX(150);
		player1L.setTranslateY(15);

		player2L.setTranslateX(300);
		player2L.setTranslateY(15);	



		//Se crean y ubican botones de rotación
		Button right = new Button("Right");
		Button left = new Button("Left");

		right.setTranslateX(335);
		right.setTranslateY(460);

		left.setTranslateX(130);
		left.setTranslateY(460);

		right.setDisable(true);
		left.setDisable(true);

		right.setPrefSize(60, 35);
		left.setPrefSize(60, 35);


		//Se crea y ubica indicador de turno
		Label turno = new Label(player1L.getText());
		turno.setFont(Font.font(10));
		Circle t = new Circle(14,Color.YELLOW);
		//25/490
		t.setTranslateX(25);
		t.setTranslateY(224);	

		turno.setTranslateX(8);
		turno.setTranslateY(240);


		//Firmas Visibles
		Label Checho = new Label("Checho!");
		Checho.setFont(Font.font(12));
		Checho.setTextFill(Color.ORANGE);
		Checho.setTranslateX(475);
		Checho.setTranslateY(490);
		Checho.setRotate(-35);
		game.getChildren().add(Checho);

		//		ImageView iv1 = new ImageView(new Image (new FileInputStream("C:/Users/checho/Desktop/cmamo.jpg")));

		ImageView iv1= new ImageView();
		ImageView iv2= new ImageView();

		//		ImageView iv2 = new ImageView(new Image( new FileInputStream(folder.getPath() + "\\ " + av2 + ".png")));




		//Se crea y se llena una matriz con los botones para jugar
		botones = new Button[6][6];
		circulos  = new Circle[6][6];
		//		for (int i = 0; i < botones.length; i++) {
		//			Arrays.fill(botones[i], new Button());
		//		}
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[0].length; j++) {
				botones[i][j]=new Button();
				//				botones[i][j].setText(c +"");
				botones[i][j].setText(i+","+j);
				botones[i][j].setTextFill(Color.TRANSPARENT);

				circulos[i][j]=new Circle(20, Color.BLUE);

			}
		}

		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[0].length; j++) {

				//			System.out.println("boton " +30*i+", "+30*j);
				//Lugar boton
				botones[i][j].setTranslateX(68*(i+1));
				botones[i][j].setTranslateY(68*(j+1));
				botones[i][j].setMinSize(40, 40);

				botones[i][j].setShape(new Circle(1));

				circulos[i][j].setTranslateX(68*(i+1)+20);
				circulos[i][j].setTranslateY(68*(j+1)+20);

				//Pone el fondo transparente 
				botones[i][j].setBackground(Background.EMPTY);
			}

		}


		//Separadores que dividen el tablero
		Separator spH = new Separator();
		Separator spV = new Separator(Orientation.VERTICAL);

		spH.setMinWidth(490);
		spV.setMinHeight(490);

		spH.setTranslateY(255);
		spH.setTranslateX(10);

		//		sp.translateXProperty().set(520);

		spV.setTranslateY(10);
		spV.setTranslateX(255);

		//CheckBox de sonido
		CheckBox cb = new CheckBox("Sonido?");
		cb.setTranslateX(10);
		cb.setTranslateY(470);
		cb.selectedProperty().set(true);
		game.getChildren().add(cb);


		//____________________________________________________________________________________________________________________________________________//
		//_________________________________________Funcion de los botones!____________________________________________________________________________//		
		//____________________________________________________________________________________________________________________________________________//		

		// centro de pane en 235,235
		for (Button[] buttons : botones) {

			for (Button buttons2 : buttons) {

				//20,20			//107,20	//195,20
				//20,107		//107,107	//195,107
				//20,195		//107,195	//195,195

				buttons2.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {	

						if (cb.isSelected()) 
						{	
							MediaPlayer sound = new MediaPlayer(new Media(
									new File("C:/Users/checho/Desktop/Coin.mp3").toURI().toString()));

							sound.play();

						}



						StringTokenizer st = new StringTokenizer(buttons2.getText(),",");
						//						System.out.println(t);
						//						if(t==0)
						//							circulos[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())].setFill(Color.YELLOW);
						//						if(t==1)
						//							circulos[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())].setFill(Color.RED);
						int i=Integer.parseInt(st.nextToken()),j=Integer.parseInt(st.nextToken());
						int[] pos= {i,j};
						//						System.out.println(Arrays.deepToString(ConnectFiveLogic.getBoard()));

						//						System.out.println(ConnectFiveLogic.play(pos));
						//						System.out.println(circulos[i][j].getTranslateX());
						//						System.out.println(circulos[i][j].getTranslateY());
						if (ConnectFiveLogic.play(pos) ) {
							System.out.println("Jugada permitida");
							disable();
							right.setDisable(false);
							left.setDisable(false);
						}
						else {
							disable();
							System.out.println("Jugada NO permitida");
							System.out.println(!ConnectFiveLogic.gameOver()+"GAME OVERRRR!");

						}

						paint();
						System.out.println("");
						//						toStrings();




					}
				});

			}
		}



		right.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				ConnectFiveLogic.rRight();	
				enable();	
				right.setDisable(true);
				left.setDisable(true);
				paint();

				//			//Alterna el turno
				if(ConnectFiveLogic.getTurno()==1) {
					t.setFill(Color.RED);
					t.setTranslateX(490);
					turno.setTranslateX(475);
					turno.setText(player2L.getText());
				}

				else{
					t.setFill(Color.YELLOW);
					t.setTranslateX(25);
					turno.setTranslateX(8);
					turno.setText(player1L.getText());
				}


				if(ConnectFiveLogic.gameOver())
				{Alert end = new Alert(AlertType.CONFIRMATION);
				end.setTitle("GameOver!");
				String ganador= "Es un empate!";

				if(ConnectFiveLogic.getWinnerScore()==1 )
					ganador = "El ganador es: "+name1.getText()+"!";
				if(ConnectFiveLogic.getWinnerScore()==2 )
					ganador = "El ganador es: "+name2.getText()+"!";



				end.setContentText("El juego ha terminado. "+ " \n "+ ganador  
						+ " \n"+ "¿Desea guardar el puntaje del ganador?" );
				end.showAndWait();

				if(end.getResult() ==ButtonType.OK)
					System.out.println("Oc");

				//try {
				//terminar sentencia de insercion de datos de ganador//
				//con.insertar("insert into scores values ("+ Judge.winnerScore +",'j2', 'yellow','123/88',2,1,3)");
				//} catch (SQLException e) {
				//// TODO Auto-generated catch block
				//e.printStackTrace();
				//}

				}



			}



		});


		left.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				ConnectFiveLogic.rLeft();	
				enable();
				right.setDisable(true);
				left.setDisable(true);
				paint();


				//Alterna el turno
				if(ConnectFiveLogic.getTurno()==1) {
					t.setFill(Color.RED);
					t.setTranslateX(490);
					turno.setTranslateX(475);
					turno.setText(player2L.getText());
				}

				else{
					t.setFill(Color.YELLOW);
					t.setTranslateX(25);
					turno.setTranslateX(8);
					turno.setText(player1L.getText());
				}


				if(ConnectFiveLogic.gameOver())
				{Alert end = new Alert(AlertType.CONFIRMATION);
				end.setTitle("GameOver!");
				String ganador= "Es un empate!";

				if(ConnectFiveLogic.getWinnerScore()==1 )
					ganador = "El ganador es: "+name1.getText()+"!";
				if(ConnectFiveLogic.getWinnerScore()==2 )
					ganador = "El ganador es: "+name2.getText()+"!";



				end.setContentText("El juego ha terminado. "+ " \n "+ ganador  
						+ " \n"+ "¿Desea guardar el puntaje del ganador?" );
				end.showAndWait();

					

				//try {
				
				if(end.getResult() ==ButtonType.OK)
				{
					try {
					
					String insert="select * from scores";
					if (Judge.getWinner()==ConnectFiveLogic.getP1()) {
						insert="insert into scores values ("+ConnectFiveLogic.getWinnerScore()+",'"+name1.getText()+"', 'Yellow','"+new Date().toString()+"', \"C:/Users/checho/Documents/Universidad/Semestre-VI/Ingeniería de Softwre I/Proyecto/Avatares/" +av1.getValue()+".png\");" ;
					}
					if (Judge.getWinner()==ConnectFiveLogic.getP2()) {
						insert="insert into scores values ("+ConnectFiveLogic.getWinnerScore()+",'"+name1.getText()+"', 'Red','"+new Date().toString()+"', \"C:/Users/checho/Documents/Universidad/Semestre-VI/Ingeniería de Softwre I/Proyecto/Avatares/" +av2.getValue()+".png\");" ;
					}
					
					System.out.println("Insercion: "+insert);
					
//					con.insertar(insert);
					Conexion.insertar(insert);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				//} catch (SQLException e) {
				//// TODO Auto-generated catch block
				//e.printStackTrace();
				//}

				}

			}




		});


		play.setOnAction(new EventHandler<ActionEvent>() {


			

			@Override
			public void handle(ActionEvent event) {
				
//				System.out.println("insert into scores values ("+ConnectFiveLogic.getWinnerScore()+",'"+name1.getText()+"', 'Yellow','"+new Date().toString()+"', \"C:/Users/checho/Documents/Universidad/Semestre-VI/Ingeniería de Softwre I/Proyecto/Avatares/" +av1.getValue()+".png\");");
//				
//				System.out.println("insert into scores values ("+ConnectFiveLogic.getWinnerScore()+",'"+name1.getText()+"', 'Red','"+new Date().toString()+"', \"C:/Users/checho/Documents/Universidad/Semestre-VI/Ingeniería de Softwre I/Proyecto/Avatares/" +av2.getValue()+".png\");");
				
				//				System.out.println(av1.getValue());
				//				System.out.println(av1.getVisibleRowCount()); 
				//				System.out.println(folder.getPath() + "/" + av1.getValue() + ".png");
				//				System.out.println("item n° "+av1.getItems().get(1));
				FileInputStream is1;
				FileInputStream is2;
				try {
					if(!av1.getValue().equals("Aleatorio"))
						is1 = new FileInputStream(folder.getPath() + "/" + av1.getValue() + ".png");
					else {
						Random rd = new Random();
						is1 = new FileInputStream(folder.getPath() + "/" + av1.getItems().get(rd.nextInt(av1.getVisibleRowCount()-1)) + ".png");
					}

					if(!av2.getValue().equals("Aleatorio"))
						is2 = new FileInputStream(folder.getPath() + "/" + av2.getValue() + ".png");
					else {
						Random rd = new Random();
						is2 = new FileInputStream(folder.getPath() + "/" + av2.getItems().get(rd.nextInt(av2.getVisibleRowCount()-1)) + ".png");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						is1 = new FileInputStream(folder.getPath() + "/def" + ".png");
						is2 = new FileInputStream(folder.getPath() + "/def" + ".png");
					} catch (FileNotFoundException e1) {
						is1=null;
						is2=null;
					}
				}
				Image im1 = new Image(is1);
				iv1.setImage(im1);

				Image im2 = new Image(is2);
				iv2.setImage(im2);

				iv1.setTranslateX(10);
				iv1.setTranslateY(270);

				iv2.setTranslateX(460);
				iv2.setTranslateY(270);

				iv1.setFitHeight(40);
				iv1.setFitWidth(40);

				iv2.setFitHeight(40);
				iv2.setFitWidth(40);

				System.out.println(av1.getValue()==(null));
				if(!(av1.getValue()==null) && !(av2.getValue()==null)) {
					if(!name1.getText().trim().equals("") && !name2.getText().trim().equals("") && av1.getValue()!=null && av2.getValue()!=null 
					&&!av1.getValue().equals(av2.getValue()) 
					|| av1.getValue().equals("Aleatorio") && av2.getValue().equals("Aleatorio") )  {
						
						if(!game.getChildren().contains(iv1))
							game.getChildren().addAll(iv1,iv2);
						
						primaryStage.show();
						home.hide();
						player1L.setText(name1.getText());
						player2L.setText(name2.getText());
						turno.setText(player1L.getText());
						av1.setDisable(true);
						av2.setDisable(true);
					}
					else
					{
						//Mostrar advertencia
						Alert nombres = new Alert(AlertType.WARNING);
						nombres.setTitle("Error");
						nombres.setHeaderText(null);
						nombres.setContentText("Revise los campos de los nombres");
						nombres.initStyle(StageStyle.UTILITY);
						nombres.showAndWait();


					}

				}
				else
				{
					//Mostrar advertencia
					Alert nombres = new Alert(AlertType.WARNING);
					nombres.setTitle("Error");
					nombres.setHeaderText(null);
					nombres.setContentText("Revise los campos de los nombres");
					nombres.initStyle(StageStyle.UTILITY);
					nombres.showAndWait();


				}

				
			}

		});


		name2.setOnKeyPressed(e -> {

			if (e.getCode() == KeyCode.ESCAPE)
				System.exit(1);

			if (e.getCode() == KeyCode.ENTER)
			{
				FileInputStream is1;
				FileInputStream is2;
				try {
					if(!av1.getValue().equals("Aleatorio"))
						is1 = new FileInputStream(folder.getPath() + "/" + av1.getValue() + ".png");
					else {
						Random rd = new Random();
						is1 = new FileInputStream(folder.getPath() + "/" + av1.getItems().get(rd.nextInt(av1.getVisibleRowCount()-1)) + ".png");
					}

					if(!av2.getValue().equals("Aleatorio"))
						is2 = new FileInputStream(folder.getPath() + "/" + av2.getValue() + ".png");
					else {
						Random rd = new Random();
						is2 = new FileInputStream(folder.getPath() + "/" + av2.getItems().get(rd.nextInt(av2.getVisibleRowCount()-1)) + ".png");
					}
				} catch (FileNotFoundException es) {
					// TODO Auto-generated catch block
					es.printStackTrace();
					is1=null;
					is2=null;
				}
				Image im1 = new Image(is1);
				iv1.setImage(im1);

				Image im2 = new Image(is2);
				iv2.setImage(im2);

				iv1.setTranslateX(10);
				iv1.setTranslateY(270);

				iv2.setTranslateX(460);
				iv2.setTranslateY(270);

				iv1.setFitHeight(40);
				iv1.setFitWidth(40);

				iv2.setFitHeight(40);
				iv2.setFitWidth(40);

				game.getChildren().addAll(iv1,iv2);

				if(!name1.getText().trim().equals("") && !name2.getText().trim().equals("") && av1.getValue()!=null && av2.getValue()!=null 
						&&!av1.getValue().equals(av2.getValue()) 
						|| av1.getValue().equals("Aleatorio") && av2.getValue().equals("Aleatorio") )  {
					primaryStage.show();
					home.hide();
					player1L.setText(name1.getText());
					player2L.setText(name2.getText());
					turno.setText(player1L.getText());
				}
				else
				{
					//Mostrar advertencia
					Alert nombres = new Alert(AlertType.WARNING);
					nombres.setTitle("Error");
					nombres.setHeaderText(null);
					nombres.setContentText("Revise los campos de los nombres");
					nombres.initStyle(StageStyle.UTILITY);
					nombres.showAndWait();

				}
				av1.setDisable(true);
				av2.setDisable(true);
			}


		});

		name1.setOnKeyPressed(e -> {

			if (e.getCode() == KeyCode.ESCAPE)
				System.exit(1);
		});


		puntajes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				R.show();
				home.hide();


			}


		});


		restart.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ConnectFiveLogic.StartConnectFiveLogic();

				paint();
				right.setDisable(true);
				left.setDisable(true);

				//____________

				t.setFill(Color.YELLOW);
				t.setTranslateX(25);
				turno.setTranslateX(8);
				turno.setText(player1L.getText());
				//____________

				enable();

			}


		});


		i1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				home.show();
				primaryStage.hide();
				R.hide();

			}
		});


		i2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				home.show();
				primaryStage.hide();
				R.hide();

			}
		});

		i3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				home.show();
				primaryStage.hide();
				R.hide();

			}
		});
		//_______________________________________________________________________________________________
		//________________________Se agregan todos los elementos al pane_____________________________________________________
		//_______________________________________________________________________________________________
		for (int i = 0; i < botones.length; i++) { 
			for (int j = 0; j < botones[0].length; j++) { 
				game.getChildren().add(circulos[i][j]);
				game.getChildren().add(botones[i][j]);
			}}

		game.getChildren().add(spH);
		game.getChildren().add(spV);

		game.getChildren().add(player1L);
		game.getChildren().add(player2L);
		game.getChildren().add(player1ICO);
		game.getChildren().add(player2ICO);

		game.getChildren().add(right);
		game.getChildren().add(left);

		game.getChildren().add(t);
		game.getChildren().add(turno);

		game.getChildren().add(i1);
		records.getChildren().add(i2);
		//		records.setContent(i2);









		//		primaryStage.show();

		//__________________________/GAME_______________________________________________________
		//_____________________________________________________________________________________
		//_____________________________________________________________________________________










	}


	private  void paint() {

		char [][] b = ConnectFiveLogic.getBoard();
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if(b[i][j]==ConnectFiveLogic.getP1())
					circulos[i][j].setFill(Color.YELLOW);
				if(b[i][j]==ConnectFiveLogic.getP2())
					circulos[i][j].setFill(Color.RED);
				if(b[i][j]==ConnectFiveLogic.getEmpty())
					circulos[i][j].setFill(Color.BLUE);

			}
		}

		toStrings();

	}

	private void disable() {

		for (Button[] buttons : botones) {

			for (Button buttons2 : buttons) {

				buttons2.setDisable(true);

			}
		}
	}

	private void enable() {

		for (Button[] buttons : botones) {

			for (Button buttons2 : buttons) {

				buttons2.setDisable(false);

			}
		}
	}



	public void toStrings() {
		for (int i = 0; i < botones.length; i++) {
			System.out.println(Arrays.toString(ConnectFiveLogic.getBoard()[i]));
		}

	}


	private Pane scores() {
		Pane puntajes = new Pane();



		return puntajes;
	} 


	private Pane Home() {
		Stage home = new Stage();
		Pane homep = new Pane();
		//Tamaño ventana
		homep.setMinSize(365, 500);
		homep.setBackground(Background.EMPTY);







		Scene homesc = new Scene(homep,Color.rgb(40, 133, 210));
		//No se puede maximizar
		home.setResizable(false);
		home.setTitle("Home");
		home.centerOnScreen();
		home.setScene(homesc);
		home.show();

		Label title = new Label("¡CONECTA CINCO EN LINEA!");
		title.setFont(Font.font("Comic Sans MS",25));

		//Lugar del titulo
		title.setTranslateX(12);		
		title.setTranslateY(25);


		Label n1 = new Label("Nombre del primer jugador:");
		Label n2 = new Label("Nombre del segundo jugador:");

		TextField name1 = new TextField();
		TextField name2 = new TextField();



		n1.setTranslateX(20);
		n1.setTranslateY(200);

		n2.setTranslateX(20);
		n2.setTranslateY(240);

		name1.setPrefSize(180, 20);
		name1.setTranslateX(175);
		name1.setTranslateY(195);

		name2.setPrefSize(170, 20);
		name2.setTranslateX(185);
		name2.setTranslateY(235);

		Button play = new Button("¡A Jugar!");
		Button help = new Button("Ayuda!");
		Button credits = new Button("Créditos");

		play.resize(60, 20);
		help.resize(60, 20);
		credits.resize(60, 20);

		play.setTranslateX(215);
		play.setTranslateY(290);

		help.setTranslateX(100);
		help.setTranslateY(290);

		credits.setTranslateX(155);
		credits.setTranslateY(340);

		homep.getChildren().add(title);
		homep.getChildren().add(n1);
		homep.getChildren().add(n2);
		homep.getChildren().add(name1);
		homep.getChildren().add(name2);
		homep.getChildren().add(play);
		homep.getChildren().add(help);
		homep.getChildren().add(credits);
		return homep;

	}




}

