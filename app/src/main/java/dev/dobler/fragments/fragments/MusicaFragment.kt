package dev.dobler.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.dobler.fragments.R
import dev.dobler.fragments.adapter.SongAdapter
import dev.dobler.fragments.model.SongModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MusicaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_musica, container, false)
        val view: View = inflater.inflate(R.layout.fragment_musica, container, false)

        val rvMusica: RecyclerView = view.findViewById(R.id.rvMusica)
        rvMusica.layoutManager = LinearLayoutManager(requireContext())
        rvMusica.adapter = SongAdapter(getSongs())
        return  view
    }

    private fun  getSongs(): List<SongModel>{
        val lstSong: ArrayList<SongModel> = ArrayList()

        lstSong.add(SongModel(1, R.drawable.boomboompow
            , "Boom Boom Pow", "The End"
            , "410000000", "4:10" ))

        lstSong.add(SongModel(2, R.drawable.igottafeeling
            , "I Gotta Felling", "The End"
            , "1500000000", "4:30" ))

        lstSong.add(SongModel(3, R.drawable.meetmehalfway
            , "Meet Me Half Way", "The End"
            , "62000000", "4:44" ))

        lstSong.add(SongModel(4, R.drawable.myhumps
            , "My Humps", "Monkey Business"
            , "410000000", "4:10" ))

        lstSong.add(SongModel(4, R.drawable.pumpit
            , "Pump It", "Monkey Business"
            , "410000000", "4:10" ))
        return lstSong
    }



}