package com.github.aakira.expandablelayout.uitest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.aakira.expandablelayout.ExpandableLinearLayout
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlin.properties.Delegates


/**
 * test for [com.github.aakira.expandablelayout.ExpandableLinearLayout#initlayout]
 *
 * The default value is  {@link android.view.animation.AccelerateDecelerateInterpolator}
 *
 */
class ExpandableLinearLayoutActivity3 : AppCompatActivity() {

    private var expandableLayout: ExpandableLinearLayout by Delegates.notNull()
    private val composite: CompositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_linear_layout3)
        supportActionBar?.title = ExpandableLinearLayoutActivity::class.java.simpleName

        expandableLayout = findViewById(R.id.expandableLayout) as ExpandableLinearLayout
        findViewById<View>(R.id.expandButton)?.setOnClickListener { expandableLayout.toggle() }
        findViewById<View>(R.id.moveChildButton)?.setOnClickListener { expandableLayout.moveChild(0) }
        findViewById<View>(R.id.moveChildButton2)?.setOnClickListener { expandableLayout.moveChild(1) }

        // uncomment if you want to check the #ExpandableLayout.initLayout()
//        val child1 = findViewById(R.id.child1) as TextView
//        subscriptions.add(Observable.timer(5, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe {
//                    child1.text =
//                            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//                    expandableLayout.initLayout()
//                    expandableLayout.expand(0, null)
//                })
    }

    override fun onDestroy() {
        composite.dispose()
        super.onDestroy()
    }
}