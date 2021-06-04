package aiss.api.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.videogames.Game;
import aiss.model.videogames.List;

public class ListResourceTest {

	public static List list1;
	public static List list2;
	public static Game game;
	public static ListResource lr = new ListResource();
	public static GameResource gr = new GameResource();

	@BeforeClass
	public static void setup() throws Exception {
		List listN = new List();

		listN.setName("Trending");
		listN.setDescription("Sample trending");

		list1 = lr.addList(listN);

		Game gameN = new Game();

		gameN.setTitle("Minecraft");
		gameN.setDeveloper("Mojang");
		gameN.setGenre("Sandbox");
		gameN.setYear("2011");
		gameN.setPrice(29.95);

		game = gr.addGame(gameN);
		
		if(game!=null) {
			lr.addGameList(list1.getId(),gameN.getId());
		}
	}

//	@AfterClass
//	public static void tearDown() throws Exception {
//		lr.deleteList(list1.getId());
//		if(game!=null) {
//			gr.deleteGame(game.getId());
//		}
//	}

	@Test
	public void testGetAll() throws UnsupportedEncodingException {
		Collection<List> lists = lr.getAll(null, null, null, null);
		
		assertNotNull("The collection of lists is null", lists);
		
		System.out.println("Listing all videogames lists");
		for(List l : lists) {
			System.out.println(l.toString());
		}
	}

	@Test
	public void testGetList() {
		List l = lr.getList(list1.getId());
		
		assertEquals("The id of the list do not match", list1.getId(), l.getId());
		assertEquals("The name of the list do not match", list1.getId(), l.getId());
		
		System.out.println(l.toString());
	}

	@Test
	public void testAddList() {
		String listName = "Example list name";
		String listDescription = "Example list description";
		
		List listn = new List();
		
		listn.setName(listName);
		listn.setDescription(listDescription);
		
		list2 = lr.addList(listn);
		
		assertNotNull("Error when adding the list", list2);
		assertEquals("The list`s name has not been setted correctly", listName, list2.getName());
		assertEquals("The list`s description has not been setted correctly", listDescription, list2.getDescription());
	}

	@Test
	public void testUpdateList() {
		String listName = "Update list name";
		
		list1.setName(listName);
		
		boolean success = lr.updateList(list1);
		
		assertTrue("Error when updating the list", success);
		
		List l = lr.getList(list1.getId());
		assertEquals("The list`s name has not been updated correctly", listName, l.getName());
	}

	@Test
	public void testDeleteList() {
		Boolean success = lr.deleteList(list2.getId());
		assertTrue("Error when deleting the playlist", success);
		
		List l = lr.getList(list2.getId());
		assertNull("The list has not been deleted correctly", l);
	}

	@Test
	public void testAddGameList() {
		if(game!=null) {
			boolean success = lr.addGameList(list1.getId(), game.getId());
			assertTrue("Error when adding the game",success);
		}
	}

	@Test
	public void testDeleteGameList() {
		if(game!=null) {
			boolean success = lr.deleteGameList(list1.getId(), game.getId());
			assertTrue("Error when delete game", success);
		}
	}

}
