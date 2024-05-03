package com.example.discord;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 각 토글 버튼의 확장 상태를 개별적으로 관리합니다.
    private boolean isExpanded1 = false;
    private boolean isExpanded2 = false;
    private boolean isExpanded3 = false;
    private boolean isExpanded4 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setupToggleButton(R.id.toggleButton1, R.id.hiddenItems1, 1);
        setupToggleButton(R.id.toggleButton2, R.id.hiddenItems2, 2);
        setupToggleButton(R.id.toggleButton3, R.id.hiddenItems3, 3);
        setupToggleButton(R.id.toggleButton4, R.id.hiddenItems4, 4);
    }

    private void setupToggleButton(int toggleButtonId, int hiddenItemsId, int index) {
        TextView toggleButton = findViewById(toggleButtonId);
        LinearLayout hiddenItems = findViewById(hiddenItemsId);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 토글 상태에 따라 보이기/숨기기 및 아이콘 변경
                switch (index) {
                    case 1:
                        isExpanded1 = !isExpanded1;
                        hiddenItems.setVisibility(isExpanded1 ? View.VISIBLE : View.GONE);
                        updateToggleButtonIcon(toggleButton, isExpanded1);
                        break;
                    case 2:
                        isExpanded2 = !isExpanded2;
                        hiddenItems.setVisibility(isExpanded2 ? View.VISIBLE : View.GONE);
                        updateToggleButtonIcon(toggleButton, isExpanded2);
                        break;
                    case 3:
                        isExpanded3 = !isExpanded3;
                        hiddenItems.setVisibility(isExpanded3 ? View.VISIBLE : View.GONE);
                        updateToggleButtonIcon(toggleButton, isExpanded3);
                        break;
                    case 4:
                        isExpanded4 = !isExpanded4;
                        hiddenItems.setVisibility(isExpanded4 ? View.VISIBLE : View.GONE);
                        updateToggleButtonIcon(toggleButton, isExpanded4);
                        break;
                }
            }
        });
    }

    private void updateToggleButtonIcon(TextView button, boolean isExpanded) {
        int iconRes = isExpanded ? R.drawable.baseline_keyboard_arrow_down_24 : R.drawable.baseline_keyboard_arrow_right_24;
        button.setCompoundDrawablesRelativeWithIntrinsicBounds(iconRes, 0, 0, 0);
    }
}
