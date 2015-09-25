package com.hnb.lazyadapter;

import android.widget.TextView;

/**
 * Created by USER on 9/25/2015.
 */
public class Executor
{
    public static BackgroundThreadExecutor backgroundThreadExecutor = BackgroundThreadExecutor.getInstance();
    public static UIThreadExecutor uiThreadExecutor = UIThreadExecutor.getInstance();

   /* public interface eCallback
    {
        void onResult(int result);

        void onError(String error);
    }*/

    public void run(final int position, final TextView textView)
    {
        backgroundThreadExecutor.runOnBackground(new Runnable()
        {
            @Override
            public void run()
            {
                Integer a = 0;
                for (int i = 0; i < 60000; i++)
                {
                    a = i;
                    a = a * 3;
                    a = a % (position + 1);
                    a = position;
                }

                uiThreadExecutor.runOnUIThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (textView != null)
                        {
                            textView.setText(position + "");
                        }
                    }
                });
            }
        });

    }

}
