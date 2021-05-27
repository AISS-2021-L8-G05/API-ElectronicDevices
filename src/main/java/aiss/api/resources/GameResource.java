package aiss.api.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.videogames.Game;

public class GameResource {
	private String uri = "https://videogames-aiss-2021.ew.r.appspot.com/api/v1/games";
	
	public Collection<Game> getAll(String orderP, String genreP, Double priceP, String titleP, Integer limitP, Integer offsetP) throws UnsupportedEncodingException {
		
		String uri2 = uri+"?";
		
		String order = orderP!=null? URLEncoder.encode(orderP,"UTF-8"):null;
		String genre = genreP!=null? URLEncoder.encode(genreP,"UTF-8"):null;
		String price = priceP!=null? URLEncoder.encode(priceP.toString(),"UTF-8"):null;
		String title = titleP!=null? URLEncoder.encode(titleP, "UTF-8"):null;
		String limit = limitP!=null? URLEncoder.encode(limitP.toString(),"UTF-8"):null;
		String offset = offsetP!=null? URLEncoder.encode(offsetP.toString(), "UTF-8"):null;
		
		
		if(order!=null) uri2+="order="+order+"&";
		if(genre!=null) uri2+="genre="+genre+"&";
		if(price!=null) uri2+="price="+price+"&";
		if(title!=null) uri2+="title="+title+"&";
		if(limit!=null) uri2+="limit="+limit+"&";
		if(offset!=null) uri2+="offset="+offset+"&";
		
		
		ClientResource cr = null;
		Game [] games = null;
		try {
			cr = new ClientResource(uri2);
			games = cr.get(Game[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving all games: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(games);
	}
	

	public Game getGame(String gameId) {		
		ClientResource cr = null;
		Game  game = null;
		
		try {
			cr = new ClientResource(uri + "/" + gameId);
			game = cr.get(Game.class);
		} catch (Exception e) {
			System.err.println("Error when retrieving the game: " + cr.getResponse().getStatus());
		}
		
		return game;
	}

	public Game addGame(Game game) {
		ClientResource cr = null;
		Game gameResult = null;
		
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			gameResult = cr.post(game, Game.class);
		} catch (Exception e) {
			System.err.println("Error when retrieving the game: " + cr.getResponse().getStatus());
		}
		
		return gameResult;

	}
	
	public boolean updateGame(Game game) {
		ClientResource cr = null;
		Boolean success = true;
		
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.put(game);
		} catch (ResourceException e) {
			System.err.println("Error when retrieving the game: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean deleteGame(String gameId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri+"/"+gameId);
			cr.setEntityBuffering(true);
			cr.delete();
		} catch (ResourceException e) {
			System.err.println("Error when retrieving the game: " + cr.getResponse().getStatus());
			success = false;
			throw e;
		}
		
		return success;
	}
}
