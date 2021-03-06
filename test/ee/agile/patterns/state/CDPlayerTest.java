package ee.agile.patterns.state;

import org.junit.Test;

import static org.junit.Assert.*;

public class CDPlayerTest {
    private CDPlayer player = new CDPlayer();

    @Test
    public void pauseButtonPausesAndResumesPlaying() throws Exception {
        player.play();

        player.pause();
        assertFalse(player.isPlaying());

        player.pause();
        assertTrue(player.isPlaying());
    }

    @Test
    public void canMoveBetweenTracks() throws Exception {
        assertEquals(1, player.getTrackNumber());

        player.forward();
        player.forward();
        assertEquals(3, player.getTrackNumber());

        player.backward();
        assertEquals(2, player.getTrackNumber());

        player.stop();
        assertEquals(1, player.getTrackNumber());
    }

    @Test(expected = IllegalStateException.class)
    public void cantPlayIfEjected() throws Exception {
        player.eject();
        player.play();
    }
}
