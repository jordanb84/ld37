package com.ld.game.state.impl;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ld.game.entity.building.impl.BuildingBarracks;
import com.ld.game.entity.building.impl.BuildingMeatFactory;
import com.ld.game.entity.impl.EntityBoat;
import com.ld.game.entity.impl.EntityPlayer;
import com.ld.game.graphics.map.Map;
import com.ld.game.state.State;
import com.ld.game.state.StateManager;

public class StateTesting extends State {

	private Map map;
	
	public StateTesting(StateManager stateManager) throws SAXException, IOException, ParserConfigurationException {
		super(stateManager);
		this.map = new Map(new File("/home/oprsec/Music/test4.xml"));
		
		EntityPlayer player = new EntityPlayer(this.map, new Vector2(100, 90));
		this.map.spawnEntity(player);
		
		this.map.spawnEntity(new BuildingBarracks(this.map, new Vector2(50, 40), player.getInventory()));
		this.map.spawnEntity(new BuildingMeatFactory(this.map, new Vector2(60, 180), player.getInventory()));
		
		//this.map.spawnEntity(new EntityPig(this.map, new Vector2(150, 270)));
		
		this.map.spawnEntity(new EntityBoat(this.map, new Vector2(400, 150)));
	}

	@Override
	public void initiate() {
		
	}

	@Override
	public void render(SpriteBatch batch) {
		this.map.render(batch);
	}

	@Override
	public void update(OrthographicCamera camera) {
		this.map.update(camera);
	}

}
