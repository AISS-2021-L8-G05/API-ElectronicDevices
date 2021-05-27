package aiss.api.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.videogames.Game;
import aiss.model.videogames.List;

public class ListResource {
	private String uri = "https://videogames-aiss-2021.ew.r.appspot.com/api/v1/lists";
	
	public Collection<List> getAll(String orderP, Boolean isEmptyP, Integer limitP, Integer offsetP) throws UnsupportedEncodingException{
		String uri2 = uri+"?";
		
		String order = orderP!=null? URLEncoder.encode(orderP,"UTF-8"):null;
		String limit = limitP!=null? URLEncoder.encode(limitP.toString(),"UTF-8"):null;
		String offset = offsetP!=null? URLEncoder.encode(offsetP.toString(), "UTF-8"):null;
		String isEmpty = isEmptyP!=null? URLEncoder.encode(isEmptyP.toString(),"UTF-8"):null;
		
		if(order!=null) uri2+="order="+order+"&";
		if(isEmpty!=null) uri2+="isEmpty"+isEmpty+"&";
		if(limit!=null) uri2+="limit="+limit+"&";
		if(offset!=null) uri2+="offset="+offset+"&";
		
		ClientResource cr = null;
		List [] lists = null;
		try {
			cr = new ClientResource(uri2);
			lists = cr.get(List[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving all games: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(lists);
	}
	
	public List getList(String listId) {
		ClientResource cr = null;
		List list  = null;
		
		try {
			cr = new ClientResource(uri + "/" + listId);
			list = cr.get(List.class);
		} catch (Exception e) {
			System.err.println("Error when retrieving the game: " + cr.getResponse().getStatus());
		}
		
		return list;
	}
	
	public List addList(List list) {
		ClientResource cr = null;
		List listResult = null;
		
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			listResult = cr.post(list, List.class);
		} catch (Exception e) {
			System.err.println("Error when retrieving the list: " + cr.getResponse().getStatus());
		}
		
		return listResult;
	}
	
	public boolean updateList(List list) {
		ClientResource cr = null;
		Boolean success = true;
		
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.put(list);
		} catch (ResourceException e) {
			System.err.println("Error when retrieving the list: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean deleteList(String listId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri+"/"+listId);
			cr.setEntityBuffering(true);
			cr.delete();
		} catch (ResourceException e) {
			System.err.println("Error when retrieving the list: " + cr.getResponse().getStatus());
			success = false;
			throw e;
		}
		
		return success;
	}
	
	public boolean addGameList(String listId, String gameId) {
		ClientResource cr = null;
		Boolean success = true;
		
		GameResource gr = new GameResource();
		
		List list = getList(listId);
		Game game = gr.getGame(gameId);
		list.getGames().add(game);
		
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.put(list);
			
		} catch (ResourceException e) {
			System.err.println("Error when retrieving the list: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean deleteGameList(String listId, String gameId) {
		ClientResource cr = null;
		Boolean success = true;
		
		GameResource gr = new GameResource();
		
		List list = getList(listId);
		Game game = gr.getGame(gameId);
		list.getGames().remove(game);
		
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.put(list);
			
		} catch (ResourceException e) {
			System.err.println("Error when retrieving the list: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
}
