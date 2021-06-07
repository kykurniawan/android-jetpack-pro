package com.rizkykurniawan.jetpackpro.submission.ui.tvshow

import com.rizkykurniawan.jetpackpro.submission.data.source.TVShowRepository
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.TVShowEntity
import com.rizkykurniawan.jetpackpro.submission.utils.DummyData
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel
    private val dummyTVShow = DummyData.generateDummyTVShows()[0]
    private val tvShowId = dummyTVShow.tvShowId
    private val wrongTVShowId = "wrongId"

    @Mock
    private lateinit var tvShowRepository: TVShowRepository

    @Before
    fun setUp() {
        viewModel = TVShowViewModel(tvShowRepository)
    }

    @Test
    fun testGetTVShows() {
        `when`(tvShowRepository.getAllTVShows()).thenReturn(DummyData.generateDummyTVShows() as ArrayList<TVShowEntity>)
        val tvShows = viewModel.getTVShows()
        verify(tvShowRepository).getAllTVShows()
        assertNotNull(tvShows)
        assertEquals(10, tvShows.size)
    }

    @Test
    fun testGetDetailTVShow() {
        `when`(tvShowRepository.getDetailTVShow(tvShowId)).thenReturn(dummyTVShow)
        val tvShow = viewModel.getDetailTVShow(tvShowId)
        verify(tvShowRepository).getDetailTVShow(tvShowId)
        assertNotNull(tvShow)
        assertEquals(dummyTVShow, tvShow)
        assertEquals(dummyTVShow.title, tvShow?.title)
        assertEquals(dummyTVShow.season, tvShow?.season)
        assertEquals(dummyTVShow.posterDrawable, tvShow?.posterDrawable)
        assertEquals(dummyTVShow.score, tvShow?.score)
        assertEquals(dummyTVShow.description, tvShow?.description)


    }

    @Test
    fun testGetDetailTVShowWithWrongId() {
        `when`(tvShowRepository.getDetailTVShow(wrongTVShowId)).thenReturn(null)
        val tvShow = viewModel.getDetailTVShow(wrongTVShowId)
        assertNull(tvShow)
    }
}