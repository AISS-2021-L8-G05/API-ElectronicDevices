package aiss.api.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.videogames.Game;

public class GameResourceTest {
	
	public static Game game1, game2;
	public static GameResource gr = new GameResource();
	
	@BeforeClass
	public static void setup() throws Exception {
		
		Game gameN = new Game();
		
		gameN.setTitle("Minecraft");
		gameN.setDeveloper("Mojang");
		gameN.setGenre("Sandbox");
		gameN.setYear("2011");
		gameN.setPrice(29.95);
		
		game1 = gr.addGame(gameN);
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		gr.deleteGame(game1.getId());
	}
	
	
	@Test
	public void testGetAll() throws UnsupportedEncodingException {
		GameResource game = new GameResource();
		
		List<Game> l = new ArrayList<Game>(game.getAll(null, null, null, null, null, null));
		
		assertNotNull("The search returned null", l);
		
		l.stream().forEach(g->System.out.println("Game: "+g));
	}

	@Test
	public void testGetGame() {
		String id = "g2";
//		GameResource game = new GameResource();
		Game gameResults = gr.getGame(id);
		
		assertNotNull("The search returned null", gameResults);
//		assertNotNull("The search returned null", game);
		
		System.out.println("Game: "+gameResults);
	}

	@Test
	public void testAddGame() {
		
		GameResource game = new GameResource();
		game.addGame(game1);
	}

	@Test
	public void testUpdateGame() {
		String id = game1.getId();
		Game gameResults = gr.getGame(id);
		
		assertNotNull("The search returned null", gameResults);
		assertNotNull("The search returned null", gr);
		
		gameResults.setYear("2020");
		gr.updateGame(gameResults);
	}

	@Test
	public void testDeleteGame() {
		String idp = game1.getId().replace('g', ' ');
		Integer idOld = Integer.valueOf(idp.trim());
		String id = "g"+(idOld+1);
		System.out.println(id);
		boolean success = gr.deleteGame(id);
		
		assertTrue("Error when deleting the game",success);
		
		Game game = gr.getGame(id);
		assertNull("The game has not been deleted correctly", game);
				
	}

}
