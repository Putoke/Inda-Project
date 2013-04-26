package game;

import java.util.HashMap;

import org.newdawn.slick.Input;

public final class Controller {

	private static HashMap<String, Integer> p1Buttons;
	private static HashMap<String, Integer> shortcuts;

	public static boolean changeP1Button(String action, int button) {
		if (!p1Buttons.containsKey(action) || p1Buttons.containsValue(button)) {
			return false;
		}

		p1Buttons.remove(action);
		p1Buttons.put(action, button);
		return true;
	}

	private static boolean addP1Button(String action, int button) {
		if (p1Buttons.containsKey(action) || p1Buttons.containsValue(button)) {
			return false;
		}

		p1Buttons.put(action, button);
		return true;
	}

	private static boolean addShortcut(String action, int button) {
		if (shortcuts.containsKey(action) || shortcuts.containsValue(button)) {
			return false;
		}

		shortcuts.put(action, button);
		return true;
	}

	public static boolean isP1ButtonPressed(String action, Input input) {
		if(p1Buttons.get(action) < 3 && input.isMouseButtonDown(p1Buttons.get(action))){
			return true;
		}
		if (!input.isKeyDown(p1Buttons.get(action))){
			return false;
		}
		return true;
	}

	public static boolean isShortcutPressed(String action, Input input) {
		if (!shortcuts.containsKey(action)
				|| !input.isKeyPressed(shortcuts.get(action))) {
			return false;
		}
		return true;
	}

	public static void init() {
		p1Buttons = new HashMap<String, Integer>();
		addP1Button("Up", Input.KEY_W);
		addP1Button("Left", Input.KEY_A);
		addP1Button("Down", Input.KEY_S);
		addP1Button("Right", Input.KEY_D);
		addP1Button("UpAlt", Input.KEY_UP);
		addP1Button("LeftAlt", Input.KEY_LEFT);
		addP1Button("DownAlt", Input.KEY_DOWN);
		addP1Button("RightAlt", Input.KEY_RIGHT);
		addP1Button("Shoot", Input.MOUSE_LEFT_BUTTON);

		shortcuts = new HashMap<String, Integer>();
		addShortcut("Fullscreen", Input.KEY_F11);
		addShortcut("Menu", Input.KEY_ESCAPE);
	}
}
