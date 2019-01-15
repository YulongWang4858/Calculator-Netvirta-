package com.example.wangyulong.caluculator;

import android.util.Log;

public class CaluculatorController extends BasicController
{
    // region Fields and Consts
    private static CaluculatorController _instance = null;
    private int current_value = 0;
    private int previous_result = 0;
    private int newInput = 0;
    private Constant.Operations current_operation = null;
    private UpdateTextViewDisplayEventListener _update_event_handler = null;

    public static CaluculatorController get_instance()
    {
        if (_instance == null)
        {
            _instance = new CaluculatorController();
        }

        return _instance;
    }

    public int getCurrentValueForDisplay()
    {
        return this.current_value;
    }


    // endregion Fields and Consts

    // region Constructor
    private  CaluculatorController()
    {

    }
    // endregion Constructor

    // region APIs
    public void updateCurrentNumber(int newNumber)
    {
        this.newInput = this.newInput * 10 + newNumber;
        this.current_value = this.newInput;

        Log.d("Debug: ", "CalculatorController: updateCurrentNumber --> current number : " + this.newInput);

        if (this._update_event_handler != null)
        {
            this._update_event_handler.onUpdateTriggered();
        }
    }

    public void performOperation(Constant.Operations operations)
    {
        switch (operations)
        {
            case PLUS:
            {
                Log.d("Debug: ", "CalculatorController: performOperation --> performing plus operation");

                this.current_operation = Constant.Operations.PLUS;

                break;
            }
            case MINUS:
            {
                Log.d("Debug: ", "CalculatorController: performOperation --> performing minus operation");
                this.current_operation = Constant.Operations.MINUS;

                break;
            }
            case DIVIDE:
            {
                Log.d("Debug: ", "CalculatorController: performOperation --> performing divide operation");
                this.current_operation = Constant.Operations.DIVIDE;

                break;
            }
            case MULTIPLY:
            {
                Log.d("Debug: ", "CalculatorController: performOperation --> performing multiply operation");
                this.current_operation = Constant.Operations.MULTIPLY;

                break;
            }
            default:
                {
                    Log.d("Debug: ", "CalculatorController: performOperation --> invalid operation");
                    this.current_operation = Constant.Operations.MULTIPLY;

                    return;
                }
        }

        // stores current value as the previous result
        this.switchNumbers();
    }

    public void eraseLastDigit()
    {
        this.newInput /= 10;
        this.current_value = this.newInput;

        if (this._update_event_handler != null)
        {
            this._update_event_handler.onUpdateTriggered();
        }
    }

    public void outputResult()
    {
        if (this.current_operation != null)
        {
            switch (this.current_operation)
            {
                case PLUS:
                {
                    this.previous_result += this.newInput;
                    break;
                }
                case MINUS:
                {
                    this.previous_result -= this.newInput;
                    break;
                }
                case MULTIPLY:
                {
                    this.previous_result *= this.newInput;
                    break;
                }
                case DIVIDE:
                {
                    this.previous_result /= this.newInput;
                    break;
                }
            }
        }

        this.current_value = this.previous_result;

        if (this._update_event_handler != null)
        {
            this._update_event_handler.onUpdateTriggered();
        }

        this.newInput = this.previous_result;

        Log.d("Debug: ", "CalculatorController: outputResult --> result : " + this.previous_result);
    }

    /*Clears all numbers in list*/
    public void clearAll()
    {
        this.current_operation = null;
        this.current_value = 0;
        this.newInput = 0;
        this.previous_result = 0;

        if (this._update_event_handler != null)
        {
            this._update_event_handler.onUpdateTriggered();
        }
    }

    public void setUpdateEventHandler(UpdateTextViewDisplayEventListener listener)
    {
        this._update_event_handler = listener;
    }
    // endregion APIs

    // region Methods
    private void switchNumbers()
    {
        this.previous_result = this.newInput;
        this.newInput = 0;
    }
    // endregion Methods
}
