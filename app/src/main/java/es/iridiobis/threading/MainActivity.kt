package es.iridiobis.threading

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import dagger.android.AndroidInjection
import es.iridiobis.threading.solution.UI
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var ui: UI

    private lateinit var scenarioSpinner: Spinner
    private lateinit var processSpinner: Spinner
    private lateinit var solutionSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareScenarioSpinner()
        prepareProcessSpinner()
        prepareSolutionSpinner()
    }

    private fun prepareScenarioSpinner() {
        scenarioSpinner = findViewById(R.id.scenario_spinner)
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.scenarios, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        scenarioSpinner.adapter = adapter
    }

    private fun prepareProcessSpinner() {
        processSpinner = findViewById(R.id.process_spinner)
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.processes, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        processSpinner.adapter = adapter
    }

    private fun prepareSolutionSpinner() {
        solutionSpinner = findViewById(R.id.solution_spinner)
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.solutions, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        solutionSpinner.adapter = adapter
    }

    fun runScenario(view: View) {
        ui.analyzeSolution(
                scenarioSpinner.selectedItemPosition,
                processSpinner.selectedItemPosition,
                solutionSpinner.selectedItem.toString()
        )
    }

}
