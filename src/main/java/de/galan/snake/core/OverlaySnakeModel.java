package de.galan.snake.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * daniel should have written a comment here.
 *
 * @author daniel
 */
public class OverlaySnakeModel extends SnakeModel {

	private Map<String, String> overlay;
	private Map<String, String> merged; // contains cached overlayed properties


	public OverlaySnakeModel(SnakeSource source, SnakeInstance instance) {
		super(source, instance);
		overlay = new HashMap<>();
		merge();
	}


	@Override
	public void set(String name, String value) {
		overlay.put(name, value);
		merge();
	}


	@Override
	public void remove(String name) {
		overlay.put(name, null);
		merge();
	}


	public void overlayReset() {
		overlay.clear();
		merge();
	}


	@Override
	public Map<String, String> getProperties() {
		return merged;
	}


	/** Revalculated the resulting properties, to avoid calculation on every access of a property */
	protected void merge() {
		merged = new HashMap<>(super.getProperties());
		for (Entry<String, String> entry: overlay.entrySet()) {
			merged.put(entry.getKey(), entry.getValue());
		}
	}

}
