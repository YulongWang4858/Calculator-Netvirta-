package com.example.wangyulong.caluculator;

import android.database.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorMainActivity extends AppCompatActivity
{
    // Fields
    private CaluculatorController controller = CaluculatorController.get_instance();
    private TextView resultDisplay = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);

        this.resultDisplay = findViewById(R.id.DisplayView);

        //this.resultDisplay.setText();
        configureEventListeners();
        buttonConfiguration();
    }

    private void configureEventListeners()
    {
        this.controller.setUpdateEventHandler(new UpdateTextViewDisplayEventListener()
        {
            @Override
            public void onUpdateTriggered()
            {
                resultDisplay.setText(String.valueOf(controller.getCurrentValueForDisplay()));
            }
        });
    }

    private void buttonConfiguration()
    {
        // numbers
        Button numButton_1 = findViewById(R.id.Number_1);
        Button numButton_2 = findViewById(R.id.Number_2);
        Button numButton_3 = findViewById(R.id.Number_3);
        Button numButton_4 = findViewById(R.id.Number_4);
        Button numButton_5 = findViewById(R.id.Number_5);
        Button numButton_6 = findViewById(R.id.Number_6);
        Button numButton_7 = findViewById(R.id.Number_7);
        Button numButton_8 = findViewById(R.id.Number_8);
        Button numButton_9 = findViewById(R.id.Number_9);

        // operations
        Button addButton = findViewById(R.id.Plus);
        Button subtractButton = findViewById(R.id.Minus);
        Button multiplyButton = findViewById(R.id.multiply);
        Button divideButton = findViewById(R.id.divide);
        Button outputButton = findViewById(R.id.equalsTo);
        Button clearAllButton = findViewById(R.id.clear);
        Button backButton = findViewById(R.id.back);

        numButton_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.updateCurrentNumber(1);
            }
        });

        numButton_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.updateCurrentNumber(2);
            }
        });

        numButton_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.updateCurrentNumber(3);
            }
        });

        numButton_4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.updateCurrentNumber(4);
            }
        });

        numButton_5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.updateCurrentNumber(5);
            }
        });

        numButton_6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.updateCurrentNumber(6);
            }
        });

        numButton_7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.updateCurrentNumber(7);
            }
        });

        numButton_8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.updateCurrentNumber(8);
            }
        });

        numButton_9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.updateCurrentNumber(9);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.performOperation(Constant.Operations.PLUS);
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.performOperation(Constant.Operations.MINUS);
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.performOperation(Constant.Operations.MULTIPLY);
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.performOperation(Constant.Operations.DIVIDE);
            }
        });

        outputButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.outputResult();
            }
        });

        clearAllButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.clearAll();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                controller.eraseLastDigit();
            }
        });
    }
}
