package com.bb.mybagsbite.Fragments


import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.bb.mybagsbite.Activity.HomePage
import com.bb.mybagsbite.Helpers.DBHelper
import com.bb.mybagsbite.Model.Users
import com.bb.mybagsbite.R
import com.bb.mybagsbite.Receiver.AppResultReceiver
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment(), View.OnClickListener, AppResultReceiver.Receiver {
    internal var username: EditText? = null
    internal var password: EditText? = null
    internal var receiver: AppResultReceiver? = null

    private var mAuthListener: FirebaseAuth.AuthStateListener? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.activity_login, container, false)
        initializeFieldsAndButtons(view)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun initializeFieldsAndButtons(view: View) {
        username = view.findViewById(R.id.username_field) as EditText
        password = view.findViewById(R.id.password_field) as EditText
        val login = view.findViewById(R.id.login_btn) as Button
        val register = view.findViewById(R.id.register_btn) as Button
        receiver = AppResultReceiver(Handler())
        //receiver.setReceiver(this)

        btnSetOnClick(login, register)

    }

    override fun onStart() {
        super.onStart()
        mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user != null) {
                // User is signed in
                //                    Intent i = new HomePage();
                //                    startActivity(i);
                val i = Intent(context, HomePage::class.java)
                startActivity(i)
            } else {
                // User is signed out
                //Log.d(TAG, "onAuthStateChanged:signed_out");
            }
            // ...
        }
    }

    private fun btnSetOnClick(vararg btns: Button) {
        for (b in btns) {
            b.setOnClickListener(this)
        }
    }

    override fun onClick(v: View) {
        val button = v.id

        when (button) {
            R.id.login_btn -> tryLogin()
            R.id.register_btn -> {
                Log.d("onRegBtn", "Clicked")
                callRegisterFragment()
            }
        }
    }

    private fun tryLogin() {
        val u = username.toString()
        val db = DBHelper(context)

        val users = db.getUsers(u)



        if (users.count == 0) {
            Toast.makeText(context, "User not found", Toast.LENGTH_SHORT).show()
        } else {
            users.moveToFirst()
            callHomePage(users.getString(users.getColumnIndex(Users.USER_FIRST_NAME)))

        }

    }

    private fun callHomePage(user: String) {


        val home = Intent(context, HomePage::class.java)
        home.putExtra(Users.USER_FIRST_NAME, user)
        startActivity(home)
    }

    private fun callRegisterFragment() {
        val regFrag = RegisterFragment.newInstance()
        val ft = fragmentManager.beginTransaction()
        //ft.setCustomAnimations(R.anim.slide_left,R.anim.slide_right);
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                android.R.anim.fade_in, android.R.anim.fade_out)
        ft.replace(R.id.frag_container, regFrag).addToBackStack(null).commit()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onReceiveResult(resultCode: Int, resultData: Bundle) {
        Log.d("ONRECEIVERESULT", "OK")

    }
}// Required empty public constructor
