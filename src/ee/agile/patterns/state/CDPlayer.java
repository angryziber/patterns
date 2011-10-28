package ee.agile.patterns.state;

public class CDPlayer {
    public void eject() {
        System.out.println("eject!");
    }

    public void play() {
        System.out.println("play!");
    }

    public void pause() {
        System.out.println("pause!");
    }

    public void next() {
        System.out.println("next track!");
    }

    public void prev() {
        System.out.println("prevous track!");
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
