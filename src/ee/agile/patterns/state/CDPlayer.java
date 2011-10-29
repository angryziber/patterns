package ee.agile.patterns.state;

import static ee.agile.patterns.state.CDPlayer.State.*;

public class CDPlayer {
    enum State {
        EJECTED,
        IDLE {
            public State play() {return PLAYING;}
        },
        PLAYING {
            public State play() {return PAUSED;}
            public State pause() {return PAUSED;}
            public State forward() {return this;}
        },
        PAUSED {
            public State play() {return PLAYING;}
            public State pause() {return PLAYING;}
        },
        LOCKED;

        public State eject() {return this;}
        public State play() {return this;}
        public State pause() {return this;}
        public State forward() {return this;}
        public State backward() {return this;}
        public State stop() {return this;}
    }

    private State state = IDLE;

    public void eject() {
        state = state.eject();
    }

    public void play() {
        state = state.play();
    }

    public void pause() {
        state = state.pause();
    }

    public void forward() {
        state = state.forward();
    }

    public void backward() {
        state = state.backward();
    }

    public void stop() {
        state = state.stop();
    }

    public boolean isDiscInside() {
        return false;
    }

    public boolean isPlaying() {
        return false;
    }

    public int getTrackNumber() {
        return 1;
    }
}
