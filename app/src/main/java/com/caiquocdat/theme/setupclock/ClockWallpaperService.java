package com.caiquocdat.theme.setupclock;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

public class ClockWallpaperService extends WallpaperService {
    @Override
    public Engine onCreateEngine() {
        return new ClockWallpaperEngine();
    }

    private class ClockWallpaperEngine extends Engine {
        private CustomClock customClock;
        private final Handler handler = new Handler(); // Create a Handler

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            customClock = new CustomClock(ClockWallpaperService.this);
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            super.onVisibilityChanged(visible);
            if (visible) {
                draw();
            } else {
                handler.removeCallbacks(drawRunner); // Remove callback when not visible
            }
        }

        private final Runnable drawRunner = new Runnable() { // Create a Runnable
            @Override
            public void run() {
                draw();
            }
        };

        private void draw() {
            SurfaceHolder holder = getSurfaceHolder();
            Canvas canvas = null;
            try {
                canvas = holder.lockCanvas();
                if (canvas != null) {
                    // Clear the canvas
                    canvas.drawColor(Color.BLACK); // Replace Color.BLACK with the background color of your clock
                    customClock.draw(canvas);
                }
            } finally {
                if (canvas != null) {
                    holder.unlockCanvasAndPost(canvas);
                }
            }
            if (isVisible()) {
                handler.postDelayed(drawRunner, 1000); // Use Handler's postDelayed
            }
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            handler.removeCallbacks(drawRunner); // Remove callback when Engine is destroyed
        }
    }
}
