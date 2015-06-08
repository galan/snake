package de.galan.snake.core;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import de.galan.commons.time.Sleeper;
import de.galan.snake.boot.BootstrapSnake;
import de.galan.snake.client.Snake;


/**
 * daniel should have written a comment here.
 *
 * @author daniel
 */
public class SmokeTest {

	@Test
	public void testName() throws Exception {
		BootstrapSnake.init();
		assertThat(Snake.get("a")).isNull();
		Sleeper.sleep("1h");
	}

}
